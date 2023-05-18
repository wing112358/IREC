package org.irecapi.Bean.Irec;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class PagingBean extends Request {

    /**
     *用户名
     */
    private String username;


    /**
     *登录密码
     */
    private String password;


}
