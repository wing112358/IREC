package org.irecapi.Irec;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.ChangeStatusBean;
import org.irecapi.Bean.Irec.QueryDetailBean;
import org.irecapi.Utils.TestngListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class queryDetailTest extends BaseTest {

    public Header[] headers;
    public Integer resultContentId;

    public JSONObject resultContent;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.resultContentId=(Integer)ctx.getAttribute("resultContentId");



    }


    @AfterGroups(groups = {"queryDetail"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("resultContent", this.resultContent);
        log.info("请求放置的回填信息："+this.resultContent);

    }





    @Test(dataProvider = "addparam",description = "获取回填部分信息",groups = {"queryDetail"},dependsOnGroups = {"changeStatus"})
    public void queryDetailTest(QueryDetailBean queryDetailBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.packageService.queryDetails(queryDetailBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取返回信息
       this.resultContent=response.getJSONObject("data");


    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";

        QueryDetailBean queryDetailBean=new QueryDetailBean(this.resultContentId);


        return new Object[][]{{
            queryDetailBean,
            expectedresult
        },};

    }



}
