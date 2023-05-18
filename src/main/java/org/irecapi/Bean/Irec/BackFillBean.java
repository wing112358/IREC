package org.irecapi.Bean.Irec;


import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

import java.sql.Timestamp;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class BackFillBean extends Request {

    /**
     *设备id
     */
    private String deviceId ;

    /**
     *项目id
     */
    private Integer id ;

    /**
     *接受账号
     */
    private String issueRecipientIrecAccountId ;

    /**
     *注册生效时间
     */
    private String registrationEffectiveTime ;

    /**
     *注册人ID
     */
    private String registrationOrganizationIrecAccountId ;



}
