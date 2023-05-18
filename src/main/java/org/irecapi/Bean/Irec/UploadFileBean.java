package org.irecapi.Bean.Irec;


import cn.hutool.core.date.DateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class UploadFileBean extends Request {

    /**
     *设备id
     */
    private String deviceId ;





}
