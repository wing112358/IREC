package org.irecapi.Irec;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.BackFillBean;
import org.irecapi.Bean.Irec.CreateIssueBean;
import org.irecapi.Bean.Irec.QueryDateBean;
import org.irecapi.Bean.common.Response;
import org.irecapi.Utils.TestngListener;
import org.irecapi.entity.Issuance;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Slf4j
@Listeners({TestngListener.class})
public class createIssueTest extends BaseTest {

    public Header[] headers;

    public Integer packageId;

    public Long issueId;



    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.packageId=(Integer) ctx.getAttribute("packageId");



    }

    @AfterGroups(groups = {"createIssue"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("issueId", this.issueId);
        log.info("请求放置的签发id："+this.issueId);

    }

    @Test(dataProvider = "addparam",description = "注册回填",groups = {"createIssue"},dependsOnGroups = {"backFill"})
    public Long createIssueTest(CreateIssueBean createIssueBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");

            response=this.issueService.create(result,this.headers,createIssueBean);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取签发ID及状态
        //开始时间处理
        Date date = new Date(Long.parseLong(createIssueBean.getIssuanceTimeStart()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = sdf.format(date);
        Issuance Issue=this.issuanceService.queryByPackageId(this.packageId,start);
        this.issueId= Issue.getId();

//        //校验签发状态
//        Assert.assertEquals(Issue.getStatus(),"1","签发状态校验不通过");
        return this.issueId;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam() throws Exception {

        return getData();

    }

    public  Object[][] getData() throws Exception {


        String expectedresult="操作成功";

        //调用查询接口获取时间段，取开始时间
        QueryDateBean  queryDateBean=new QueryDateBean(this.packageId);
        JSONObject response=this.issueService.queryDate(expectedresult,this.headers,queryDateBean);

        String startTime="";
        List<String> issueList=(List<String>)response.getJSONObject("data").get("issuedTimeList");
        String pendingTimeStart=response.getJSONObject("data").getString("pendingTimeStart");
        String pendingTimeEnd=response.getJSONObject("data").getString("pendingTimeEnd");

        startTime=this.getStartTime(pendingTimeStart,pendingTimeEnd,issueList);
        String endTime=this.getEndTime(startTime);


        CreateIssueBean createIssueBean=new CreateIssueBean(endTime,startTime,this.packageId);


        return new Object[][]{{
            createIssueBean,
            expectedresult
        },};

    }

    public String getEndTime(String starTime){
        // 将时间戳转换为日期对象
        Instant instant = Instant.ofEpochMilli(Long.parseLong(starTime));
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        //获取当月的最后一天，即下个月的第一天的前一天：
        LocalDateTime lastDayOfMonth = localDateTime.with(TemporalAdjusters.lastDayOfMonth());


        // 将该日期转换为时间戳
        ZoneId zone = ZoneId.systemDefault();
        long lastDayTimestamp = lastDayOfMonth.atZone(zone).toInstant().toEpochMilli();

        // 将时间戳增加至 23:59:59:999
        long lastMinuteTimestamp = lastDayTimestamp + 23 * 60 * 60 * 1000 + 59 * 60 * 1000+59*1000+999;

        // 将该日期格式化为字符串
        String endTime =String.valueOf(lastMinuteTimestamp);

        return endTime;
    }



    public String getStartTime(String startTime,String endTime,List<String> list) throws ParseException {

        String start="";

        Long startDate=Long.parseLong(startTime);
        Long endDate=Long.parseLong(endTime);

        if(list.size()==0){
            start=startTime;
        }else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(startDate);
            calendar.add(Calendar.MONTH, 1); // 加一个月
            Long newTimestamp = calendar.getTimeInMillis();
            if(list.contains(newTimestamp.toString())&&newTimestamp<endDate){
                Calendar calendar1 = Calendar.getInstance();
                calendar1.setTimeInMillis(newTimestamp);
                calendar1.add(Calendar.MONTH, 1); // 加一个月
                start=String.valueOf(calendar1.getTimeInMillis());

            }else{
                start=String.valueOf(newTimestamp);
            }
        }

        return start;
    }



    }






