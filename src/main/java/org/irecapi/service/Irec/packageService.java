package org.irecapi.service.Irec;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.irecapi.Bean.Irec.*;
import org.irecapi.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 登录接口调用
 */

@Service
public class packageService extends BaseService {

    String PREVIEW_URL="/api/packages/queryPreview";

    String CONFIRM_URL="/api/packages/confirm";

    String GENERATE_DOCUMENTS_URL="/api/packages/generateRegistrationDocuments";

    String SIGN_DOCUMENTS_URL="/api/packages/generateRegistrationDocumentsSignature";

    String CHANGE_STATUS_URL="/api/packages/createOfficialWebsiteRegistrationStatus";

    String GET_DETAIL_URL="/api/packages/queryRegistrationResultContent";
    String BACKFILL_URL="/api/packages/createRegistrationResultContent";



    public JSONObject preview(QueryPreviewBean queryPreviewBean, String result, Header[] headers) throws Exception {


        return this.baseGetMethod(queryPreviewBean,result,headers,PREVIEW_URL);
    }

    public JSONObject confirm(ConfirmBean confirmBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(confirmBean,result,headers,CONFIRM_URL);
    }

    public JSONObject generateDocument(GenerateDocumentBean generateDocumentBean, String result, Header[] headers) throws Exception {


        return this.basePostPMethod(generateDocumentBean,result,headers,GENERATE_DOCUMENTS_URL);
    }

    public JSONObject signDocument(SignDocumentBean signDocumentBean, String result, Header[] headers) throws Exception {


        return this.baseGetMethod(signDocumentBean,result,headers,SIGN_DOCUMENTS_URL);
    }

    public JSONObject queryDetails(QueryDetailBean queryDetailBean, String result, Header[] headers) throws Exception {


        return this.baseGetMethod(queryDetailBean,result,headers,GET_DETAIL_URL);
    }

    public JSONObject changeStatus(ChangeStatusBean changeStatusBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(changeStatusBean,result,headers,CHANGE_STATUS_URL);
    }

    public JSONObject backfill(BackFillBean backfillBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(backfillBean,result,headers,BACKFILL_URL);
    }






}
