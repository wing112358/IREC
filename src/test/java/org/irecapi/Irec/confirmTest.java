package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.ConfirmBean;
import org.irecapi.Bean.Irec.QueryPreviewBean;
import org.irecapi.Utils.TestngListener;
import org.irecapi.Utils.YamlDataHelper;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Listeners({TestngListener.class})
public class confirmTest extends BaseTest {

    public Header[] headers;

    public Long projectId;

    public List<Integer> baseList=new ArrayList<>();

    public Integer packageId;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");
        this.baseList=(List<Integer>)ctx.getAttribute("baseList");


    }

    @AfterGroups(groups = {"confirm"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("packageId", this.packageId);
        log.info("请求放置的打包项目id："+this.packageId);

    }



    @Test(dataProvider = "addparam",description = "分析确认",groups = {"confirm"},dependsOnGroups = {"preview"})
    public Integer confirmTest(ConfirmBean confirmBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.packageService.confirm(confirmBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //放置打包项目id
        this.packageId=response.getIntValue("data");





        return this.packageId;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData("normal");

    }

    public  Object[][] getData(String casename) throws Exception {
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("Irec","confirmData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        ConfirmBean confirmBean=new ConfirmBean(this.baseList);


        return new Object[][]{{
            confirmBean,
            expectedresult
        },};

    }



}
