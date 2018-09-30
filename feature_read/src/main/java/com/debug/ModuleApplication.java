package com.debug;

import android.app.Application;

/**********************************************************************
 *
 * 这个Application只在组件模式下使用，在gradle中设置了exclude 'debug/'
 *
 * @类名 ModuleApplication
 * @包名 com.debug
 * @author hanchao@frogshealth.com
 * @创建日期 2018/9/29
 ***********************************************************************/
public class ModuleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("这是Module的Application");
    }
}
