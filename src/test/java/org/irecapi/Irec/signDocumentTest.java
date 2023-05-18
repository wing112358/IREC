package org.irecapi.Irec;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.irecapi.BaseTest;
import org.irecapi.Bean.Irec.GenerateDocumentBean;
import org.irecapi.Bean.Irec.SignDocumentBean;
import org.irecapi.Utils.TestngListener;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.IOException;

@Slf4j
@Listeners({TestngListener.class})
public class signDocumentTest extends BaseTest {

    public Header[] headers;

    public JSONArray fileList=new JSONArray();




    @BeforeClass(alwaysRun = true)
    public void setHeaderAndWorkId(ITestContext ctx){
        //获取header
        this.headers= (Header[])ctx.getAttribute("headers");
        this.fileList= (JSONArray)ctx.getAttribute("fileList");



    }



    @Test(description = "文件签章",groups = {"signDocument"},dependsOnGroups = {"generateDocument"})
    public void signDocumentTest(){

        JSONObject response=null;

        JSONObject file=new JSONObject();


        for(int i=0;i<fileList.size();i++){
            file=fileList.getJSONObject(i);

            if(file.get("type").equals("reg")){
                SignDocumentBean signDocumentBean=new SignDocumentBean(file.getLong("id"));
                try{

                    log.info("准备开始---------");
                    response=this.packageService.signDocument(signDocumentBean, "操作成功",this.headers);
                    log.info(response.toString());



                }catch (IOException e){
                    log.info("开始执行---------");
                    e.printStackTrace();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
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
