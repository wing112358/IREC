package org.irecapi.Bean.Irec;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.irecapi.Bean.common.Request;

/**
 登录参数实体
 */

@Data
@AllArgsConstructor
public class CreateMeasurementSampleBean extends Request {

    /**
     *项目Id
     */
    private Long projectId;


    /**
     *并网结算清单
     */
    private JSONArray gridConnectedElectricityListAtt;

    /**
     *并网售电发票
     */
    private JSONArray gridConnectedElectricitySalesInvoiceAtt;

    /**
     *电能表列表
     */
    private JSONArray meterList;

    /**
     *其他文件
     */
    private JSONArray otherAtt;

    /**
     *消纳结算清单
     *
     */
    private JSONArray siteConsumptiveElectricityListAtt;

    /**
     *消纳售电发票
     */
    private JSONArray siteConsumptiveElectricitySalesInvoiceAtt	;


}
