package org.irecapi.Bean.Irec;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class QueryMaterialDetailBean extends Request {

    /**
     *签发ID
     */
    private Integer id;




}
