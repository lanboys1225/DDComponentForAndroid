package com.mjn.investment.ui.main;

import com.mjn.libs.base.IMainLibActivityContract;

/**
 * @author 蓝兵
 */
public interface IMainAppContract {

    interface IMainAppView
            extends IMainLibActivityContract.IJzkSellerActivityView<IMainAppPresenter> {

    }

    interface IMainAppPresenter
            extends IMainLibActivityContract.IJzkSellerActivityPresenter<IMainAppView, IMainAppModule> {

    }

    interface IMainAppModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
