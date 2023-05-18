package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.CreateContractDataBean;
import org.irecapi.Bean.Irec.QueryPreviewBean;
import org.irecapi.Bean.Irec.SampleTranslationBean;
import org.irecapi.Utils.TestngListener;
import org.irecapi.Utils.YamlDataHelper;
import org.irecapi.entity.Project;
import org.irecapi.entity.ProjectRegistrationData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Listeners({TestngListener.class})
public class previewTest extends BaseTest {

    public Header[] headers;

    public Long projectId;

    public List<Integer> baseList=new ArrayList<>();


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");


    }

    @AfterGroups(groups = {"preview"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("baseList", this.baseList);
        log.info("请求放置的项目id列表："+this.baseList);

    }



    @Test(dataProvider = "addparam",description = "打包分析",groups = {"preview"},dependsOnGroups = {"finishProject"})
    public List<Integer> previewTest(QueryPreviewBean queryPreviewBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.packageService.preview(queryPreviewBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //放置匹配项目id
        JSONArray data=response.getJSONArray("data");

        JSONObject temp;
        for(int i=0;i<data.size();i++){
             temp=data.getJSONObject(i);
            this.baseList.add(temp.getIntValue("id"));
        }



        return this.baseList;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData("normal");

    }

    public  Object[][] getData(String casename) throws Exception {
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("Irec","previewData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        QueryPreviewBean queryPreviewBean=new QueryPreviewBean(this.projectId);


        return new Object[][]{{
            queryPreviewBean,
            expectedresult
        },};

    }



}
