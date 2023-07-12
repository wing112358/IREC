package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.GenerateDocumentBean;
import org.irecapi.Bean.Irec.IssueGenerateDocumentBean;
import org.irecapi.Utils.TestngListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class generateIssueDocumentTest extends BaseTest {

    public Header[] headers;

    public Integer issueId;

    public JSONArray issueFileList=new JSONArray();



    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        Long a=(Long) ctx.getAttribute("issueId");
        this.issueId=a.intValue() ;



    }

    @AfterGroups(groups = {"generateIssueDocument"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("issueFileList", this.issueFileList);
        log.info("请求放置的签发打包文件列表："+this.issueFileList);

    }



    @Test(dataProvider = "addparam",description = "生成签发文件",groups = {"generateIssueDocument"},dependsOnGroups = {"createIssuanceProjectMaterial"})
    public JSONArray generateIssueDocumentTest(IssueGenerateDocumentBean issueGenerateDocumentBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.issueService.generateDocument( result,this.headers,issueGenerateDocumentBean);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //放置文件list
        this.issueFileList=response.getJSONArray("data");

        //校验文件内容





        return this.issueFileList;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";

        IssueGenerateDocumentBean generateDocumentBean=new IssueGenerateDocumentBean(this.issueId);


        return new Object[][]{{
            generateDocumentBean,
            expectedresult
        },};

    }



}
