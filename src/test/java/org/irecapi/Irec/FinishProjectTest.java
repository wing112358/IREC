package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.FinishBean;
import org.irecapi.Bean.Irec.SignatureBean;
import org.irecapi.Bean.Irec.UpdateFileBean;
import org.irecapi.Utils.TestngListener;
import org.irecapi.entity.Project;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class FinishProjectTest extends BaseTest {

    public Header[] headers;

    public Long projectId;





    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");



    }




    @Test(dataProvider = "addparam",description = "完成子项目整理",groups = {"finishProject"},dependsOnGroups = {"handleDocument"})
    public Long FinishProjectTest(FinishBean finishBean,String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.createService.finish(finishBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //核对项目状态
        Project project =this.projectService.queryById(this.projectId);
        int status=project.getStatus();

        Assert.assertEquals(status,2,"项目表状态核对不通过");







        return this.projectId;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {

        FinishBean finishBean=new FinishBean(this.projectId.intValue());


        String expectedresult="操作成功";

        return new Object[][]{{
            finishBean,
            expectedresult
        },};

    }



}
