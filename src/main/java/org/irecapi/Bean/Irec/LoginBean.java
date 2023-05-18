package org.irecapi.Bean.Irec;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.irecapi.Bean.common.Request;

@AllArgsConstructor
@Slf4j
@Data
public class LoginBean extends Request {
    /**
     *登录手机号
     */
    private String username;


    /**
     *验证码
     */
    private String password;

    /**
     *终端类型
     */
    private Integer terminal;



}
