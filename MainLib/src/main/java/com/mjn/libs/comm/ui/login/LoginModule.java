package com.mjn.libs.comm.ui.login;

import com.bing.lan.comm.rx.OnDataChangerListener;
import com.mjn.libs.base.MainLibActivityModule;

/**
 * @author 蓝兵
 */
public class LoginModule extends MainLibActivityModule
        implements ILoginContract.ILoginModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);
    }
}
