package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseLoginTest;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.CreateBean;
import org.irecapi.Bean.Irec.CreateMapLocationBean;
import org.irecapi.Utils.RandomUtil;
import org.irecapi.Utils.TestngListener;
import org.irecapi.Utils.YamlDataHelper;
import org.irecapi.entity.Project;
import org.irecapi.entity.ProjectRegistrationData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Listeners({TestngListener.class})
public class createMapLocationTest extends BaseTest {

    public Header[] headers;

    public Long projectId;



    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx) throws Exception {
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");

    }



    @Test(dataProvider = "addparam",description = "维护地图信息测试",groups = {"createMapLocation"},dependsOnGroups = {"createSitePhoto"})
    public void createMapLocationTest(CreateMapLocationBean createMapLocationBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.createService.createMapLocation(createMapLocationBean, result,this.headers);
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

        Assert.assertEquals(status,1,"项目表状态核对不通过");

        //核对经纬度
        ProjectRegistrationData projectData=this.projectRegistrationDataService.queryByProjectId(this.projectId);
        String AddressLanLon=projectData.getPowerGenerationFacilitiesAddressLanLon();
        Assert.assertEquals(AddressLanLon,createMapLocationBean.getPowerGenerationFacilitiesAddressLanLon(),"经纬度校验不通过");



    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData("normal");

    }

    public  Object[][] getData(String casename) throws Exception {
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("Irec","createMapLocationData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");


        CreateMapLocationBean createMapLocationBean=param.toJavaObject(CreateMapLocationBean.class);

        createMapLocationBean.setProjectId(this.projectId);
        List<JSONArray> temp=this.upload(1);

        createMapLocationBean.setPowerGenerationFacilitiesAddressScreenshotAtt(temp.get(0));


        return new Object[][]{{
            createMapLocationBean,
            expectedresult
        },};

    }



}
