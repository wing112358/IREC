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
public class CreateContractDataBean extends Request {

    /**
     *项目Id
     */
    private Long projectId;


    /**
     *合同信息中文内容
     */
    private JSONObject contractKeyInfoChinese;

    /**
     *合同信息英文内容
     */
    private JSONObject contractKeyInfoEnglish;

    /**
     *合同信息
     */
    private JSONArray contractAtt;





}
