package org.irecapi.Irec;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;

import org.irecapi.BaseLoginTest;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.*;
import org.irecapi.Utils.RandomUtil;
import org.irecapi.Utils.TestngListener;
import org.irecapi.Utils.YamlDataHelper;
import org.irecapi.entity.Project;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.Random;

@Slf4j
@Listeners({TestngListener.class})
public class createTest extends BaseTest {

    public Header[] headers;

    public Long projectId;

    public String projectName;


    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= new BaseLoginTest().loginnormaltest("17800000001","A147258");

    }

    @AfterGroups(groups = {"create"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("projectId", this.projectId);
        log.info("请求放置的项目id："+this.projectId);

        ctx.setAttribute("projectName", this.projectName);
        log.info("请求放置的项目名称："+this.projectName);

        ctx.setAttribute("headers", this.headers);
        log.info("请求放置的header："+this.headers);
    }


    @Test(dataProvider = "addparam",description = "新建测试",groups = {"create"})
    public Long createTest(CreateBean createBean, String result){

        JSONObject response=null;

        try{

            log.info("准备开始---------");
            response=this.createService.create(createBean, result,this.headers);
            log.info(response.toString());



        }catch (IOException e){
            log.info("开始执行---------");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //获取项目ID
        this.projectId=response.getLong("data");
        System.out.println("项目id为："+this.projectId);

        //校验项目信息
        Project project=this.projectService.queryById(this.projectId);

        Assert.assertEquals(project.getName(),this.projectName,"项目名称校验不通过");
        Assert.assertEquals(project.getStatus().intValue(),1,"项目状态校验不通过");
        return projectId;

    }



    @DataProvider(name = "addparam")
    public Object[][] addparam()  {

        return getData("normal");

    }

    public  Object[][] getData(String casename){
        JSONObject jsonresult=new YamlDataHelper().getYamlDataByCase("Irec","createData",casename);


        String expectedresult=jsonresult.getString("expectedresult");

        JSONObject param=jsonresult.getJSONObject("params");

        JSONObject chinese=param.getJSONObject("chinese");
        JSONObject english=param.getJSONObject("english");

        Integer random=new RandomUtil().randomString(8);
       this.projectName="Robot项目"+random;
        String englishProName="Robot project "+random;


        chinese.put("name",projectName);
        english.put("name",englishProName);


        CreateBean createBean=new CreateBean(chinese,english);


        return new Object[][]{{
            createBean,
            expectedresult
        },};

    }



}
