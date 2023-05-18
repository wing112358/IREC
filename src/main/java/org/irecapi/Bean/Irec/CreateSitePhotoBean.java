package org.irecapi.Bean.Irec;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class CreateSitePhotoBean extends Request {

    /**
     *项目Id
     */
    private Long projectId;

    /**
     *状态
     */
    private Integer status;


    /**
     *门头照
     */
    private JSONArray siteDoorPhotoAtt;

    /**
     *近景照
     */
    private JSONArray siteNearPhotoAtt;

    /**
     *全景照
     */
    private JSONArray sitePhotoAtt;




}
