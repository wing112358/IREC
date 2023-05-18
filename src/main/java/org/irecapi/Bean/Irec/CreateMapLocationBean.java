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
public class CreateMapLocationBean extends Request {

    /**
     *发电设施所在位置
     */
    private String powerGenerationFacilitiesAddress;


    /**
     *发电设施所在位置的经纬度坐标
     */
    private String powerGenerationFacilitiesAddressLanLon;

    /**
     *地图定位截图
     */
    private JSONArray powerGenerationFacilitiesAddressScreenshotAtt;


    /**
     *项目ID
     */
    private Long projectId;


}
