package com.zslin.basic.json;

/**
 * Created by zsl-pc on 2016/9/19.
 */
public class JsonNormalDto {

    private Integer resCode;

    private String resMsg;

    public Integer getResCode() {
        return resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResCode(Integer resCode) {
        this.resCode = resCode;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public JsonNormalDto(Integer resCode, String resMsg) {
        this.resCode = resCode;
        this.resMsg = resMsg;
    }
}
