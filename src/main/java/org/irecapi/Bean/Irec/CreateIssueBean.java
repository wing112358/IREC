package org.irecapi.Bean.Irec;


import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class CreateIssueBean extends Request {

    /**
     *签发终止时间
     */
    private String issuanceTimeEnd;


    /**
     *签发起始时间
     */
    private String issuanceTimeStart;

    /**
     *包id
     */
    private Integer packageId;


}
