package com.laojiang.utilslibrary.weight.finalhttp;

/**
 * 类介绍（必填）：上传视频基类
 * Created by Jiang on 2017/3/16 8:24.
 */

public class PushFileBean {

    /**
     * code : 1
     * msg : null
     * result : /public/outlesson/image//VID_20170228_193532_20170316082051250.mp4
     */

    private String code;
    private Object msg;
    private String result;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
