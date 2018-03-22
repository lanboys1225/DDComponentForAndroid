package com.mjn.libs.comm.ui.h5.activity;

import com.mjn.libs.base.IMainLibActivityContract;

/**
 * @author 蓝兵
 */
public interface IWebViewContract {

    interface IWebViewView
            extends IMainLibActivityContract.IJzkSellerActivityView<IWebViewPresenter> {

    }

    interface IWebViewPresenter
            extends IMainLibActivityContract.IJzkSellerActivityPresenter<IWebViewView, IWebViewModule> {

    }

    interface IWebViewModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
