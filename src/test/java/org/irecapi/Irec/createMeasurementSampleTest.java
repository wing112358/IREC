package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.CreateMapLocationBean;
import org.irecapi.Bean.Irec.CreateMeasurementSampleBean;
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
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Slf4j
@Listeners({TestngListener.class})
public class createMeasurementSampleTest extends BaseTest {

    public Header[] headers;

    public Long projectId;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");

    }



    @Test(dataProvider = "addparam",description = "维护计量信息",groups = {"createMeasurementSample"},dependsOnGroups = {"CreatePrimaryWiringDiagram"})
    public void createMeasurementSampleTest(CreateMeasurementSampleBean createMeasurementSampleBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.createService.createMeasurement(createMeasurementSampleBean, result,this.headers);
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



    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData("normal");

    }

    public  Object[][] getData(String casename) throws Exception {
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("Irec","createMeasurementSampleData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");


        CreateMeasurementSampleBean createMeasurementSampleBean=param.toJavaObject(CreateMeasurementSampleBean.class);

        createMeasurementSampleBean.setProjectId(this.projectId);

        List<JSONArray> temp=this.upload(5);
        //塞文件内容
        createMeasurementSampleBean.setGridConnectedElectricityListAtt(temp.get(0));
        createMeasurementSampleBean.setGridConnectedElectricitySalesInvoiceAtt(temp.get(1));
        createMeasurementSampleBean.setSiteConsumptiveElectricityListAtt(temp.get(2));
        createMeasurementSampleBean.setGridConnectedElectricityListAtt(temp.get(3));
        createMeasurementSampleBean.setOtherAtt(temp.get(4));

        //塞电能表内容
        Random random = new Random();

        List<String> meterMeasurementType= Arrays.asList("Power Generation","Deliver to Grid","On-site Consume");
        List<String> meterType=Arrays.asList("scalar","interval");

        JSONArray meterList=new JSONArray();
        for(int i=0;i<3;i++){
            JSONObject temp1=new JSONObject();
            int index = random.nextInt(meterMeasurementType.size());
            String randomMeasure = meterMeasurementType.get(index);
            int index1 = random.nextInt(meterType.size());
            String randomType = meterType.get(index1);

            int num = random.nextInt(900000) + 100000;

            temp1.put("meterId",num);
            temp1.put("meterMeasurementType",randomMeasure);
            temp1.put("meterType",randomType);

            meterList.add(temp1);
        }

        createMeasurementSampleBean.setMeterList(meterList);



        return new Object[][]{{
            createMeasurementSampleBean,
            expectedresult
        },};

    }



}
