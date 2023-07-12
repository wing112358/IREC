package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.*;
import org.irecapi.Utils.TestngListener;
import org.irecapi.entity.Issuance;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

@Slf4j
@Listeners({TestngListener.class})
public class createIssuanceProjectMaterialTest extends BaseTest {

    public Header[] headers;
    public Integer issueId;

    public List<JSONObject> IssueProjectData=new ArrayList<>();



    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        Long a=(Long) ctx.getAttribute("issueId");
        this.issueId=a.intValue() ;



    }

    @AfterGroups(groups = {"createIssuanceProjectMaterial"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("IssueProjectData", this.IssueProjectData);
        log.info("请求放置的签发项目id整理信息："+this.IssueProjectData);

    }

    @Test(dataProvider = "addparam",description = "整理",groups = {"createIssuanceProjectMaterial"},dependsOnGroups = {"createIssue"})
    public void createIssuanceProjectMaterialTest( String result) throws Exception {

        JSONObject response=null;

        this.setData();

        try{

            log.info("准备开始---------");

            //循环调用整理项目资料

            for(JSONObject temp:this.IssueProjectData){
            //拼接参数

                //获取子项目id
                Integer id=temp.getInteger("projectId");
                JSONArray data=temp.getJSONArray("data");
                JSONArray datatemp=new JSONArray();


                for(Object a:data){
                    JSONObject b=(JSONObject)a;
                    //上传文件
                    List<JSONArray> file=this.upload(5);

                    Thread.sleep(1000);
                    //塞文件内容
                    b.put("siteConsumptiveElectricityListAtt",file.get(0));
                    b.put("siteConsumptiveElectricitySalesInvoiceAtt",file.get(1));
                    b.put("gridConnectedElectricityListAtt",file.get(2));
                    b.put("gridConnectedElectricitySalesInvoiceAtt",file.get(3));
                    b.put("other",file.get(4));

                    //设置文件属性
                    JSONObject power=b.getJSONObject("power");
                    Random random = new Random();
                    int randomNum1 = random.nextInt(999 - 1 + 1) + 1;
                    int randomNum2 = random.nextInt(999 - 1 + 1) + 1;
                    String Num =randomNum1+"."+randomNum2;
                    Double dNum=Double.parseDouble(Num);

                    power.put("onSiteConsumptionPower",dNum);
                    power.put("gridConnectedPower",dNum);
                    power.put("totalPower",dNum+dNum);
                    power.put("pendingPower",dNum+dNum);

                    b.put("power",power);
                    //填写电能表信息

                    JSONArray meterList=b.getJSONArray("meterList");
                    JSONArray meterListtemp=new JSONArray();
                    for(Object c:meterList){
                        JSONObject d=(JSONObject)c;
                        d.put("power",dNum);
                        meterListtemp.add(d);
                    }
                    b.put("meterList",meterListtemp);

                    datatemp.add(b);


                }


                CreateMaterialBean createMaterialBean=new CreateMaterialBean(id,datatemp);
                response=this.issueService.createMaterial(result,this.headers,createMaterialBean);
                log.info(response.toString());

            }





        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取签发ID及状态

//        return this.issueId;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";
        return new Object[][]{{
            expectedresult
        },};

    }

    public List<JSONObject> setData() throws Exception {
        //调用接口获取签发项目Id列表
        QueryIssueDetailBean queryIssueDetailBean=new QueryIssueDetailBean(this.issueId);
        JSONObject temp=this.issueService.query("操作成功",this.headers,queryIssueDetailBean);
        JSONArray childrenProjectList=temp.getJSONObject("data").getJSONArray("childrenProjectList");
        List<Integer> issueProjectIdList=new ArrayList<>();

        for(Object a:childrenProjectList){
            JSONObject b=(JSONObject)a;
            issueProjectIdList.add(b.getIntValue("id"));
        }

        //获取电能表信息
        JSONObject single=new JSONObject();
        for(Integer id:issueProjectIdList){
            single.put("projectId",id);
//            JSONArray  material=new JSONArray();
            QueryMaterialDetailBean queryMaterialDetailBean=new QueryMaterialDetailBean(id);
            JSONObject m=this.issueService.queryMaterial("操作成功",this.headers,queryMaterialDetailBean);
            JSONArray data=m.getJSONArray("data");
            single.put("data",data);

            this.IssueProjectData.add(single);
        }



        return IssueProjectData;
    }

    }






