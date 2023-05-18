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
public class CreatePrimaryWiringDiagramBean extends Request {

    /**
     *项目Id
     */
    private Long projectId;


    /**
     *英文内容
     */
    private JSONArray primaryWiringDiagramAtt;


    /**
     *项目Id
     */
    private Double capacity;

}
