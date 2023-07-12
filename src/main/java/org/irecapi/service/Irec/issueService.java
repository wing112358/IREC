package org.irecapi.service.Irec;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.irecapi.Bean.Irec.SignatureBean;
import org.irecapi.Bean.Irec.UpdateFileBean;
import org.irecapi.Bean.common.Request;
import org.irecapi.service.BaseService;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * 登录接口调用
 */

@Service
public class issueService extends BaseService {

    String QUERY_DATE_URL="/api/issuance/queryIssuanceDate";

    String CREATE_ISSUE_URL="/api/issuance/create";

    String QUERY_DETAIL_URL="/api/issuance/queryDetail";

    String QUERY_MATERIAL_URL="/api/issuance/queryIssuanceProjectMaterial";

    String CREATE_MATERIAL_URL="/api/issuance/createIssuanceProjectMaterial";

    String GENERATE_DOCUMENT_URL="/api/issuance/generateIssuanceDocuments";

    String SIGN_DOCUMENT_URL="/api/issuance/generateIssuanceDocumentsSignature";

    String FINISH_URL="/api/issuance/finish";

    String CREATE_RESULT_URL="/api/issuance/createIssuanceResult";


    public JSONObject queryDate(String result, Header[] headers, Request request) throws Exception {


        return this.baseGetMethod(request,result,headers,QUERY_DATE_URL);
    }

    public JSONObject create(String result, Header[] headers, Request request) throws Exception {


        return this.basePostMethod(request,result,headers,CREATE_ISSUE_URL);
    }
    public JSONObject query(String result, Header[] headers, Request request) throws Exception {


        return this.baseGetMethod(request,result,headers,QUERY_DETAIL_URL);
    }

    public JSONObject queryMaterial(String result, Header[] headers, Request request) throws Exception {


        return this.baseGetMethod(request,result,headers,QUERY_MATERIAL_URL);
    }

    public JSONObject createMaterial(String result, Header[] headers, Request request) throws Exception {


        return this.basePostMethod(request,result,headers,CREATE_MATERIAL_URL);
    }

    public JSONObject generateDocument(String result, Header[] headers, Request request) throws Exception {


        return this.basePostPMethod(request,result,headers,GENERATE_DOCUMENT_URL);
    }

    public JSONObject signDocument(String result, Header[] headers, Request request) throws Exception {


        return this.baseGetMethod(request,result,headers,SIGN_DOCUMENT_URL);
    }
    public JSONObject finish(String result, Header[] headers, Request request) throws Exception {


        return this.baseGetMethod(request,result,headers,FINISH_URL);
    }


    public JSONObject createResult(String result, Header[] headers, Request request) throws Exception {


        return this.baseGetMethod(request,result,headers,CREATE_RESULT_URL);
    }







}
