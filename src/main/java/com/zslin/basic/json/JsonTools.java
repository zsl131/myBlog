package com.zslin.basic.json;

import org.json.JSONObject;

/**
 * Created by zsl-pc on 2016/9/19.
 */
public class JsonTools {

    public static String buildJsonNormalStr(Integer resCode, String resMsg) {
        JsonNormalDto dto = new JsonNormalDto(resCode, resMsg);
        JSONObject json = new JSONObject(dto);
        return json.toString();
    }
}
