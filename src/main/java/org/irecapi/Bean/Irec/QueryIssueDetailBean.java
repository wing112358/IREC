package org.irecapi.Bean.Irec;


import com.alibaba.fastjson.JSONArray;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class QueryIssueDetailBean extends Request {

    /**
     *签发ID
     */
    private Integer id;




}
