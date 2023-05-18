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
public class translationService extends BaseService {

    String TRANSLAT_URL="/api/translation";
    String SAMPLE_TRANSLAT_URL="/api/translation/simple";

    public JSONObject translat(TranslationBean translationBean, String result, Header[] headers) throws Exception {


        return this.basePostMethod(translationBean,result,headers,TRANSLAT_URL);
    }

    public JSONObject sampleTranslat(SampleTranslationBean sampleTranslationBean, String result, Header[] headers) throws Exception {


        return this.baseGetMethod(sampleTranslationBean,result,headers,SAMPLE_TRANSLAT_URL);
    }




}
