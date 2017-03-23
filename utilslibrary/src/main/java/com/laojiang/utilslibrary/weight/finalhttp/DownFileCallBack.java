package com.laojiang.utilslibrary.weight.finalhttp;

import java.io.File;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/17 14:56.
 */

public interface DownFileCallBack {
    void onSuccess(File file);
    void onFailure(String err);
}
