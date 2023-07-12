package org.irecapi.Irec;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.BackFillBean;
import org.irecapi.Bean.Irec.CreateResultBean;
import org.irecapi.Utils.TestngListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class createResultTest extends BaseTest {

    public Header[] headers;

    public Integer issueId;



    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        Long a=(Long) ctx.getAttribute("issueId");
        this.issueId=a.intValue() ;



    }

    @Test(dataProvider = "addparam",description = "签发回填",groups = {"createResult"},dependsOnGroups = {"finish"})
    public void createResultTest(CreateResultBean createResultBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.issueService.createResult(result, this.headers,createResultBean);
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

        CreateResultBean backFillBean=new CreateResultBean(this.issueId,1);


        return new Object[][]{{
                backFillBean,
            expectedresult
        },};

    }



}
