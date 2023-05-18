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
public class CreateBean extends Request {

    /**
     *中文内容
     */
    private JSONObject chinese;


    /**
     *英文内容
     */
    private JSONObject english;


}
