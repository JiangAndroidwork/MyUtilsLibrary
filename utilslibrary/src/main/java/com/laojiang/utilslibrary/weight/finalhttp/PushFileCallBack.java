package com.laojiang.utilslibrary.weight.finalhttp;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/17 15:09.
 */

public interface PushFileCallBack {
    void onSuccess(PushFileBean pushFileBean);
    void onFailure(String err);
}
