package org.irecapi;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.irecapi.service.Irec.*;
import org.irecapi.service.IssuanceService;
import org.irecapi.service.ProjectRegistrationDataService;
import org.irecapi.service.ProjectService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import javax.annotation.Resource;
import java.io.File;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    /**
     * 重写服务
     */

    @Autowired
    public loginService loginservice;

    @Autowired
    public createService createService;

    @Autowired
    public translationService translationService;

    @Autowired
    public baseWorkService baseWorkService;

    @Autowired
    public packageService packageService;

    @Autowired
    public issueService issueService;

    @Resource
    public ProjectService projectService;

    @Resource
    public IssuanceService issuanceService;

    @Resource
    public ProjectRegistrationDataService projectRegistrationDataService;


    public List<JSONArray> upload(Integer N) throws Exception {

        //获取header
        Header[] headers= new BaseLoginTest().loginnormaltest("17800000001","A147258");

        List<JSONArray> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            JSONArray temp=new JSONArray();
            int randomNum = (int) Math.round(Math.random());

            String filepath= MessageFormat.format("./fileData/{0}.pdf",randomNum);

            File file=new File(filepath);

            JSONObject upload=this.baseWorkService.upload("操作成功",headers,file);

            System.out.println(upload);


            JSONArray a=upload.getJSONArray("data");

            for(Object b:a){
                JSONObject c=(JSONObject)b;
                JSONObject d=c.getJSONObject("userFile");

                JSONObject e=new JSONObject();
                e.put("id",d.get("id"));
                e.put("name",d.get("name"));
                e.put("path",d.get("path"));
                temp.add(e);
            }
            list.add(temp);
        }


        System.out.println(list);

        return list;

    }








}
