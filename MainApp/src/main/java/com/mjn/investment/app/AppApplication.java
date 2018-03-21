package com.mjn.investment.app;

import android.app.Application;

import com.luojilab.component.componentlib.router.ui.UIRouter;

public class AppApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        UIRouter.getInstance().registerUI("app");

        //如果isRegisterCompoAuto为false，则需要通过反射加载组件
        //        Router.registerComponent("com.luojilab.reader.applike.ReaderAppLike");
        //        Router.registerComponent("com.luojilab.share.applike.ShareApplike");
    }
}
