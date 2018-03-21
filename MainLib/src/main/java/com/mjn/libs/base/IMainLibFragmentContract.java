package com.mjn.libs.base;

import com.bing.lan.comm.mvp.fragment.IBaseFragmentContract;

public interface IMainLibFragmentContract {

    interface IMainLibFragmentView<T extends IMainLibFragmentPresenter>
            extends IBaseFragmentContract.IBaseFragmentView<T> {

    }

    interface IMainLibFragmentPresenter<T extends IMainLibFragmentView,
            M extends IJzkSellerFragmentModule>
            extends IBaseFragmentContract.IBaseFragmentPresenter<T, M> {

    }

    interface IJzkSellerFragmentModule extends IBaseFragmentContract.IBaseFragmentModule {

    }
}
