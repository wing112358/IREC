package org.irecapi.Bean.Irec;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class GenerateSingleDocumentBean extends Request {

    /**
     *项目id
     */
    private Integer projectId;



}
