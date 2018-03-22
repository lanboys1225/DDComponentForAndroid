package com.mjn.libs.comm.ui.login;

import com.mjn.libs.base.IMainLibActivityContract;

/**
 * @author 蓝兵
 */
public interface ILoginContract {

    interface ILoginView
            extends IMainLibActivityContract.IJzkSellerActivityView<ILoginPresenter> {

    }

    interface ILoginPresenter
            extends IMainLibActivityContract.IJzkSellerActivityPresenter<ILoginView, ILoginModule> {

        void login(String phone, String password);
    }

    interface ILoginModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
