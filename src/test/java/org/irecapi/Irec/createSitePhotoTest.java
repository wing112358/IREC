package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.CreateMapLocationBean;
import org.irecapi.Bean.Irec.CreateSitePhotoBean;
import org.irecapi.Utils.TestngListener;
import org.irecapi.Utils.YamlDataHelper;
import org.irecapi.entity.Project;
import org.irecapi.entity.ProjectRegistrationData;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

@Slf4j
@Listeners({TestngListener.class})
public class createSitePhotoTest extends BaseTest {

    public Header[] headers;

    public Long projectId;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");

    }



    @Test(dataProvider = "addparam",description = "维护现场图片",groups = {"createSitePhoto"},dependsOnGroups = {"create"})
    public void createSitePhotoTest(CreateSitePhotoBean createSitePhotoBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.createService.createSitephoto(createSitePhotoBean, result,this.headers);
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

        //上传内容
        ProjectRegistrationData projectData=this.projectRegistrationDataService.queryByProjectId(this.projectId);
        JSONArray sitePhoto=JSONArray.parseArray(projectData.getSitePhoto());
        Assert.assertEquals(sitePhoto,createSitePhotoBean.getSitePhotoAtt(),"现场照片校验不通过");



    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData("normal");

    }

    public  Object[][] getData(String casename) throws Exception {
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("Irec","createSitePhotoData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");


        CreateSitePhotoBean createSitePhotoBean=param.toJavaObject(CreateSitePhotoBean.class);

        createSitePhotoBean.setProjectId(this.projectId);

        List<JSONArray> temp=this.upload(3);

        JSONArray newArray=new JSONArray();
        newArray.addAll(temp.get(0));
        newArray.addAll(temp.get(1));
        newArray.addAll(temp.get(2));

        createSitePhotoBean.setSitePhotoAtt(newArray);





        return new Object[][]{{
            createSitePhotoBean,
            expectedresult
        },};

    }



}
