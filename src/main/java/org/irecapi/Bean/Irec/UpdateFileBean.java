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
public class UpdateFileBean extends Request {

    /**
     *文件id
     */
    private String fileId ;

    /**
     *类型（project项目 issuance签发）
     */
    private String type ;

    /**
     *是否完成批注（0未完成 1已完成 默认为0）
     */
    private Integer isAnnotations ;




}
