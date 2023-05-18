package org.irecapi.Bean.Irec;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.irecapi.Bean.common.Request;

@AllArgsConstructor
@Slf4j
@Data
public class TranslationBean extends Request {
    /**
     *原文
     */
    private JSONObject original ;






}
