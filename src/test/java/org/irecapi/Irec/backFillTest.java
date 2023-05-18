package org.irecapi.Irec;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.BackFillBean;
import org.irecapi.Bean.Irec.GenerateDocumentBean;
import org.irecapi.Utils.TestngListener;
import org.irecapi.entity.Project;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class backFillTest extends BaseTest {

    public Header[] headers;

    public JSONObject resultContent;



    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.resultContent=(JSONObject) ctx.getAttribute("resultContent");



    }

    @Test(dataProvider = "addparam",description = "注册回填",groups = {"backFill"},dependsOnGroups = {"queryDetail"})
    public void backFillTest(BackFillBean backfillBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.packageService.backfill(backfillBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //核对子项目及打包项目状态
//        Project project =this.projectService.queryById(this);
//        int status=project.getStatus();
//
//        Assert.assertEquals(status,2,"打包项目表状态核对不通过");




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";

        BackFillBean backFillBean=new BackFillBean("DV008899",this.resultContent.getIntValue("id"),this.resultContent.getString("issueRecipientIrecAccountId"),
                "2023-01-01T00:00:00.429Z",this.resultContent.getString("registrationOrganizationIrecAccountId"));


        return new Object[][]{{
                backFillBean,
            expectedresult
        },};

    }



}
