package org.irecapi.service.Irec;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.irecapi.Bean.Irec.LoginBean;
import org.irecapi.Bean.common.Response;
import org.irecapi.Utils.HttprequestUtil;
import org.irecapi.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 登录接口调用
 */

@Service
public class loginService extends BaseService {

    String LOGIN_URL="/api/uaa/user/login";


    public JSONObject login(LoginBean loginBean, String result) throws Exception {

        Header [] headers={};
        return this.basePostMethod(loginBean,result,headers,LOGIN_URL);
    }

    public JSONObject loginByParam(String usrname,String password, String result) throws Exception {

        BaseService base=new BaseService();
        Header [] headers={};

        //写入请求参数
        LoginBean loginBean=new LoginBean(usrname,password,1);


        return this.basePostMethod(loginBean,result,headers,LOGIN_URL);
    }
}
