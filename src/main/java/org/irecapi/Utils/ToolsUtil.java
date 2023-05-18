package org.irecapi.Utils;

import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;

public class ToolsUtil {

    public static void assertMsgAndData(JSONObject response, String result) {
        if (JsonUtil.getString(response, "result") == null) {
            Assert.assertTrue(response.toString().contains(result),
                    String.format("全文 %s 不包含 %s", response.toString(), result));
        } else {
            Assert.assertEquals(JsonUtil.getString(response, "msg"), result);
        }

    }
}
