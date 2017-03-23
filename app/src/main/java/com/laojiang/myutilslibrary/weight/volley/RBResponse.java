package com.laojiang.myutilslibrary.weight.volley;

/**
 *
 * 用于封装服务器返回的json信息。RBResponse 包含公共的response字段。
 */
public class RBResponse {


    protected int code;
    protected String msg;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String message) {
        this.msg = message;
    }

}
