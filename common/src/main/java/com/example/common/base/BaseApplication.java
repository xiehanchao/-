package com.example.common.base;

import android.app.Application;

/**********************************************************************
 *
 *
 * @类名 BaseApplication
 * @包名 com.example.common.base
 * @author hanchao@frogshealth.com
 * @创建日期 2018/9/29
 ***********************************************************************/
public class BaseApplication extends Application {
    /**
     * Application实例对象
     */
    private static BaseApplication sInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
