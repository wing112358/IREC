package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.BackFillBean;
import org.irecapi.Bean.Irec.ChangeStatusBean;
import org.irecapi.Bean.Irec.GenerateDocumentBean;
import org.irecapi.Utils.TestngListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class changeStatusTest extends BaseTest {

    public Header[] headers;



    public Integer packageId;

    public Integer resultContentId;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.packageId=(Integer)ctx.getAttribute("packageId");



    }
    @AfterGroups(groups = {"changeStatus"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("resultContentId", this.resultContentId);
        log.info("请求放置的注册内容id："+this.resultContentId);

    }





    @Test(dataProvider = "addparam",description = "状态改变",groups = {"changeStatus"},dependsOnGroups = {"signDocument"})
    public void changeStatusTest(ChangeStatusBean changeStatusBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.packageService.changeStatus(changeStatusBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取返回的内容ID

        this.resultContentId=response.getIntValue("data");

        //校验状态




    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";

        ChangeStatusBean changeStatusBean=new ChangeStatusBean(this.packageId.toString(),1);


        return new Object[][]{{
            changeStatusBean,
            expectedresult
        },};

    }



}
