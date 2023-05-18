package org.irecapi.service.Irec;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.Header;
import org.irecapi.Bean.Irec.*;
import org.irecapi.Bean.common.Response;
import org.irecapi.Utils.HttprequestUtil;
import org.irecapi.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * 登录接口调用
 */

@Service
public class createService extends BaseService {

    String CREATE_URL="/api/project/create";
    String CREATE_MAP_LOCATION_URL="/api/project/createMapLocation";
    String CREATE_SITEPHOTO_URL="/api/project/createSitePhoto";
    String CREATE_CONTRACT_URL="/api/project/createContractData";
    String CREATE_DIAGRAM_URL="/api/project/createPrimaryWiringDiagram";
    String CREATE_MEASUREMENT_URL="/api/project/createMeasurementSample";

    String GENERATE_REGISTRATION_DOCUMENTS_URL="/api/project/generateRegistrationDocuments";

    String FINISH_URL="/api/project/finish";

    public JSONObject create(CreateBean createBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(createBean,result,headers,CREATE_URL);
    }

    public JSONObject createMapLocation(CreateMapLocationBean createMapLocationBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(createMapLocationBean,result,headers,CREATE_MAP_LOCATION_URL);
    }

    public JSONObject createSitephoto(CreateSitePhotoBean createSitePhotoBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(createSitePhotoBean,result,headers,CREATE_SITEPHOTO_URL);
    }

    public JSONObject createContract(CreateContractDataBean createContractDataBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(createContractDataBean,result,headers,CREATE_CONTRACT_URL);
    }

    public JSONObject createDiagram(CreatePrimaryWiringDiagramBean createPrimaryWiringDiagramBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(createPrimaryWiringDiagramBean,result,headers,CREATE_DIAGRAM_URL);
    }

    public JSONObject createMeasurement(CreateMeasurementSampleBean createMeasurementSampleBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(createMeasurementSampleBean,result,headers,CREATE_MEASUREMENT_URL);
    }

    public JSONObject generateSingleDocuments(GenerateSingleDocumentBean generateSingleDocumentBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(generateSingleDocumentBean,result,headers,GENERATE_REGISTRATION_DOCUMENTS_URL);
    }

    public JSONObject finish(FinishBean finishBean, String result, Header[] headers) throws Exception {


        return this.baseGetMethod(finishBean,result,headers,FINISH_URL);
    }


}
