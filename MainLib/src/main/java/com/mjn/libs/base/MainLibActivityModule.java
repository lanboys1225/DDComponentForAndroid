package com.mjn.libs.base;

import com.bing.lan.comm.mvp.activity.BaseActivityModule;
import com.bing.lan.comm.rx.OnDataChangerListener;

/**
 * @author 蓝兵
 */

public abstract class MainLibActivityModule extends BaseActivityModule
        implements IMainLibActivityContract.IMainLibActivityModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
    }
}
