package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.CreateContractDataBean;
import org.irecapi.Bean.Irec.CreateMapLocationBean;
import org.irecapi.Bean.Irec.SampleTranslationBean;
import org.irecapi.Bean.Irec.TranslationBean;
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
public class createContractTest extends BaseTest {

    public Header[] headers;

    public Long projectId;

    public String projectName;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");
        this.projectName=(String)ctx.getAttribute("projectName");


    }



    @Test(dataProvider = "addparam",description = "维护所有权信息",groups = {"createContract"},dependsOnGroups = {"createMapLocation"})
    public void createContractTest(CreateContractDataBean createContractDataBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.createService.createContract(createContractDataBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }



        //核对合同信息及项目名称

        ProjectRegistrationData projectData=this.projectRegistrationDataService.queryByProjectId(this.projectId);
        Project project=this.projectService.queryById(this.projectId);

        //核对项目状态
        int status=project.getStatus();

        Assert.assertEquals(status,1,"项目表状态核对不通过");

        String pProjectName=project.getName();
        Assert.assertEquals(pProjectName,this.projectName,"项目表项目名称校验不通过");
        String name=projectData.getProjectName();
        Assert.assertEquals(name,this.projectName,"详细信息表项目名校验不通过");

        JSONArray contract=JSONArray.parseArray(projectData.getContract());

        Assert.assertEquals(contract.get(0),createContractDataBean.getContractAtt().get(0),"文件地址校验不通过");



    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData("normal");

    }

    public  Object[][] getData(String casename) throws Exception {
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("Irec","createContractData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        JSONObject chinese=param.getJSONObject("contractKeyInfoChinese");
        JSONObject english=param.getJSONObject("contractKeyInfoEnglish");
        JSONArray contract=param.getJSONArray("contractAtt");

        this.projectName=projectName+"123";
        SampleTranslationBean sampleTranslationBean=new SampleTranslationBean(this.projectName);
        JSONObject transalations=this.translationService.sampleTranslat(sampleTranslationBean,"操作成功",this.headers);

        String enProjectName=transalations.getString("data");

        chinese.put("projectName",this.projectName);
        english.put("projectName",enProjectName);



        CreateContractDataBean createContractDataBean=new CreateContractDataBean(this.projectId,chinese,english,contract);

        List<JSONArray> temp=this.upload(1);

        createContractDataBean.setContractAtt(temp.get(0));

        return new Object[][]{{
            createContractDataBean,
            expectedresult
        },};

    }



}
