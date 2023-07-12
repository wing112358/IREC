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
public class CreateMaterialBean extends Request {

    /**
     *签发项目ID
     */
    private Integer id;


    /**
     *签发项目数据
     */
    private JSONArray issuanceProjectDataList;


}
