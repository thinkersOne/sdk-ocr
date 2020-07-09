package com.ocr.common.res;

public class OcrResponse {
    private Integer code;
    private String msg;
    private Object data;

    public OcrResponse() {
    }

    public OcrResponse(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public OcrResponse code(Integer code) {
        this.code = code;
        return this;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
