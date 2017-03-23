package com.laojiang.myutilslibrary.application;

import android.app.Application;

/**
 * 类介绍（必填）：
 * Created by Jiang on 2017/3/23 8:30.
 */

public class DemoApplication extends Application {
    public static DemoApplication application;
    @Override
    public void onCreate() {
        super.onCreate();
            this.application = this;
    }
    public static DemoApplication getInstance(){
        return application;
    }
}
