package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.GenerateDocumentBean;
import org.irecapi.Bean.Irec.SignatureBean;
import org.irecapi.Bean.Irec.UpdateFileBean;
import org.irecapi.Utils.GetPathWithURLUtil;
import org.irecapi.Utils.TestngListener;
import org.irecapi.entity.Project;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class HandleDocumentTest extends BaseTest {

    public Header[] headers;

    public Long projectId;

    public JSONArray singleFileList=new JSONArray();




    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.projectId=(Long)ctx.getAttribute("projectId");
        this.singleFileList=(JSONArray) ctx.getAttribute("singleFileList");



    }

    @AfterGroups(groups = {"handleDocument"}, alwaysRun=true)
    public void setWorkId(ITestContext ctx){
        ctx.setAttribute("singleFileList", this.singleFileList);
        log.info("请求放置的子项目文件列表："+this.singleFileList);

    }



    @Test(dataProvider = "addparam",description = "批注签名文件",groups = {"handleDocument"},dependsOnGroups = {"generateSingleDocument"})
    public JSONArray HandleDocumentTest( String result){



        try{

            //遍历文件处理部分
            for(Object file:this.singleFileList){
               JSONObject json=(JSONObject)file;

               if(json.get("type").equals("ten")){
                   SignatureBean sign=new SignatureBean(json.getInteger("id"));
                   JSONObject response=this.baseWorkService.signature(result,sign,this.headers);

                   System.out.println("签章结果："+response.get("data"));
               }else if(json.get("type").equals("own")||json.get("type").equals("line")||json.get("type").equals("mea")){
                   UpdateFileBean update=new UpdateFileBean(json.getString("fileId"),"project", 1) ;

                   String path= GetPathWithURLUtil.getPath(json.getString("path"));
                   File file1=new File(path);
                   JSONObject response1=this.baseWorkService.update(result,update,this.headers,file1);

                   Thread.sleep(1000);

                   System.out.println("批注结果："+response1.get("data"));
               }

            }


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

        return this.singleFileList;

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



}
