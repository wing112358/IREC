package org.irecapi.service.Irec;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.irecapi.Bean.Irec.*;
import org.irecapi.service.BaseService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 登录接口调用
 */

@Service
public class baseWorkService extends BaseService {

    String UPLOAD_FILE_URL="/api/common/file/upload";

    String UPDATE_FILE_URL="/api/file/pdf/updateFile";

    String SIGNATURE_FILE_URL="/api/project/generateRegistrationDocumentsSignature";


    public JSONObject upload(String result, Header[] headers, File file) throws Exception {


        return this.basePostFMethod(result,null,headers,UPLOAD_FILE_URL,file);
    }

    public JSONObject update(String result, UpdateFileBean updateFileBean,Header[] headers, File file) throws Exception {


        return this.basePostFMethod(result,updateFileBean,headers,UPDATE_FILE_URL,file);
    }

    public JSONObject signature(String result, SignatureBean signatureBean,Header[] headers) throws Exception {


        return this.baseGetMethod(signatureBean,result,headers,SIGNATURE_FILE_URL);
    }




}
