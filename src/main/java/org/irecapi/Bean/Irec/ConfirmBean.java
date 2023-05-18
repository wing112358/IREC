package org.irecapi.Bean.Irec;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

import java.util.List;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class ConfirmBean extends Request {

    /**
     *项目列表
     */
    private List<Integer> projectIds;



}
