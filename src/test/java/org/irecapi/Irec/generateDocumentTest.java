package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.ConfirmBean;
import org.irecapi.Bean.Irec.GenerateDocumentBean;
import org.irecapi.Utils.TestngListener;
import org.irecapi.Utils.YamlDataHelper;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Listeners({TestngListener.class})
public class generateDocumentTest extends BaseTest {

    public Header[] headers;

    public Long projectId;

    public JSONArray fileList=new JSONArray();

    public Integer packageId;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");
        this.packageId=(Integer)ctx.getAttribute("packageId");



    }

    @AfterGroups(groups = {"generateDocument"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("fileList", this.fileList);
        log.info("请求放置的打包文件列表："+this.fileList);

    }



    @Test(dataProvider = "addparam",description = "生成注册文件",groups = {"generateDocument"},dependsOnGroups = {"confirm"})
    public JSONArray generateDocumentTest(GenerateDocumentBean generateDocumentBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.packageService.generateDocument(generateDocumentBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //放置文件list
        this.fileList=response.getJSONArray("data");

        //校验文件内容





        return this.fileList;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";

        GenerateDocumentBean generateDocumentBean=new GenerateDocumentBean(this.packageId);


        return new Object[][]{{
            generateDocumentBean,
            expectedresult
        },};

    }



}
