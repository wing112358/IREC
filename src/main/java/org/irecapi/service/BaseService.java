package org.irecapi.service;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.irecapi.Bean.common.Environment;
import org.irecapi.Bean.common.Request;
import org.irecapi.Bean.common.Response;
import org.irecapi.Utils.AESUtil;
import org.irecapi.Utils.EnvironmentUtil;
import org.irecapi.Utils.HttprequestUtil;
import org.irecapi.Utils.JsonUtil;
import org.testng.Assert;

import java.io.File;
import java.util.ResourceBundle;

/**
 * 服务基类
 */
public class BaseService {

    /**
     *
     */
//    @Resource
//    public EnvironmentUtil environmentUtil;

    /**
     *设置环境方法
     */

    public String setUrl( String servicename){

        String BASEURL=new EnvironmentUtil().getUrl(Environment.Test,servicename);
        return BASEURL;
    }
    /**
     *获取请求基础域名
     */
    public String getValue( String key){

        ResourceBundle bundle = ResourceBundle.getBundle("application");
        String value=bundle.getString(key);

        return value;
    }
    /**
     *获取请求基础域名
     */
    public String Baseurl=this.setUrl("irec");


    public String PRIVATEKEY=getValue("PRIVATEKEY");


    public String PUBLICKEY=getValue("PUBLICKEY");

    public Integer sign_flag=Integer.parseInt(getValue("sign_flag"));

    public JSONObject basePostFMethod(String result, Request request,Header[] headers, String url,File file) throws Exception {
        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);
            //发送请求
            response=new HttprequestUtil().postWithFile(Baseurl+url, null,request,headers,file);

        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }


    public JSONObject basePostMethod(Request request, String result, Header[] headers,  String url) throws Exception {
        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(sign_flag==1){

            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+url,request,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postJson(Baseurl+url,request,null,headers);
        }



        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }

    public JSONObject basePostPMethod(Request request, String result, Header[] headers,  String url) throws Exception {
        //flag=1--加密；flag=0--不加密

        Response response=new Response(null,null,null,null);

        if(sign_flag==1){

            //发送请求
            response=new HttprequestUtil().postWithSign(Baseurl+url,request,null,headers);
        }else {
            //发送请求
            response=new HttprequestUtil().postForm(Baseurl+url,request,null,headers);
        }



        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }

    public JSONObject baseGetMethod(Request request, String result, Header[] headers,  String url) throws Exception {
        //flag=1--加密；flag=0--不加密

            //发送请求
        Response  response=new HttprequestUtil().get(Baseurl+url,request,null,headers);



        //获取当前方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        //校验返回
        JSONObject jsonresult=new JSONObject(assertMsgAndData(response,result,methodName));

        return jsonresult;
    }


    public JSONObject  assertMsgAndData(Response response, String result, String methodName) {

        Integer code=response.getStatusCode();

        JSONObject resultcontent=new JSONObject();

        if(sign_flag==1){
            String decresult= AESUtil.decrypt(response.getResponseContent().replace("\"",""),PRIVATEKEY);
            resultcontent= JsonUtil.jsonstring2Jsonobject(decresult);
        }else{
            resultcontent= JsonUtil.jsonstring2Jsonobject(response.getResponseContent());
        }



        if(code.equals(200)) {
            if (resultcontent.get("status").equals(200)) {
                Assert.assertEquals(JsonUtil.getString(resultcontent, "message"), result);
            } else {
                Assert.fail(methodName+"接口调用失败，响应为:" + resultcontent);
            }
        }else{
            //失败则打印失败状态码
            Assert.fail(methodName+"接口调用失败，响应为:" + response.getStatusCode());
        }


        return resultcontent;


    }
}
