package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.IssueGenerateSingleDocumentBean;
import org.irecapi.Bean.Irec.SignDocumentBean;
import org.irecapi.Bean.Irec.UpdateFileBean;
import org.irecapi.Utils.GetPathWithURLUtil;
import org.irecapi.Utils.TestngListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class signIssueDocumentTest extends BaseTest {

    public Header[] headers;

    public JSONArray issueFileList=new JSONArray();




    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.issueFileList= (JSONArray)ctx.getAttribute("issueFileList");



    }



    @Test(description = "签发文件签章",groups = {"signIssueDocument"},dependsOnGroups = {"generateIssueDocument"})
    public void signIssueDocumentTest() throws Exception {

        JSONObject response=null;

        JSONObject file=new JSONObject();


        for(int i=0;i<issueFileList.size();i++){
            file=issueFileList.getJSONObject(i);

            if(file.get("type").equals("req")){
                IssueGenerateSingleDocumentBean signDocumentBean=new IssueGenerateSingleDocumentBean(file.getInteger("id"));
                try{

                    log.info("准备开始---------");
                    response=this.issueService.signDocument( "操作成功",this.headers,signDocumentBean);
                    log.info(response.toString());



                }catch (IOException e){
                    log.info("开始执行---------");
                    e.printStackTrace();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            } else if(file.get("type").equals("mea")){
                UpdateFileBean update=new UpdateFileBean(file.getString("fileId"),"issuance", 1) ;

                String path= GetPathWithURLUtil.getPath(file.getString("path"));
                File file1=new File(path);
                JSONObject response1=this.baseWorkService.update("操作成功",update,this.headers,file1);

                Thread.sleep(1000);

                System.out.println("批注结果："+response1.get("data"));
            }else{
                System.out.println(file.get("nameCh")+"不需要处理");
            }
        }



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
