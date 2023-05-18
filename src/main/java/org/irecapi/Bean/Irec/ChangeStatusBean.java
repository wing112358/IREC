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
public class ChangeStatusBean extends Request {

    /**
     *项目id
     */
    private String id ;

    /**
     *回填状态
     */
    private Integer status ;





}
