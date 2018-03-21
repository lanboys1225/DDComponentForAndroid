package com.mjn.libs.base;

import com.bing.lan.comm.mvp.activity.IBaseActivityContract;

public interface IMainLibActivityContract {

    interface IJzkSellerActivityView<T extends IJzkSellerActivityPresenter> extends IBaseActivityContract.IBaseActivityView<T> {

    }

    interface IJzkSellerActivityPresenter<T extends IJzkSellerActivityView, M extends IMainLibActivityModule>
            extends IBaseActivityContract.IBaseActivityPresenter<T, M> {

    }

    interface IMainLibActivityModule extends IBaseActivityContract.IBaseActivityModule {

    }
}
