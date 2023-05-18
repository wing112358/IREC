package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.GenerateDocumentBean;
import org.irecapi.Bean.Irec.GenerateSingleDocumentBean;
import org.irecapi.Utils.TestngListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class generateSingleDocumentTest extends BaseTest {

    public Header[] headers;

    public Long projectId;

    public JSONArray singleFileList=new JSONArray();




    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");



    }

    @AfterGroups(groups = {"generateSingleDocument"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("singleFileList", this.singleFileList);
        log.info("请求放置的子项目文件列表："+this.singleFileList);

    }



    @Test(dataProvider = "addparam",description = "生成子项目注册文件",groups = {"generateSingleDocument"},dependsOnGroups = {"createMeasurementSample"})
    public JSONArray generateSingleDocumentTest(GenerateSingleDocumentBean generateSingleDocumentBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.createService.generateSingleDocuments(generateSingleDocumentBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //放置文件list
        this.singleFileList=response.getJSONArray("data");

        //校验文件内容





        return this.singleFileList;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";

        GenerateSingleDocumentBean generateSingleDocumentBean=new GenerateSingleDocumentBean(Integer.valueOf(this.projectId.intValue()));


        return new Object[][]{{
                generateSingleDocumentBean,
            expectedresult
        },};

    }



}
