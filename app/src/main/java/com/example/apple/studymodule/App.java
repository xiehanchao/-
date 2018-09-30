package com.example.apple.studymodule;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.common.base.BaseApplication;

/**********************************************************************
 *
 *
 * @类名 App
 * @包名 com.example.apple.studymodule
 * @author hanchao@frogshealth.com
 * @创建日期 2018/9/29
 ***********************************************************************/
public class App extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化路由
        if (BuildConfig.DEBUG) {
            //一定要在ARouter.init之前调用openDebug
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
