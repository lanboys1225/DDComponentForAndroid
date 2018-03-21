package com.mjn.libs.base.test.activity;

import com.mjn.libs.base.IMainLibActivityContract;

/**
 * @author 蓝兵
 */
public interface IActivityTestContract {

    interface IActivityTestView
            extends IMainLibActivityContract.IJzkSellerActivityView<IActivityTestPresenter> {

    }

    interface IActivityTestPresenter
            extends IMainLibActivityContract.IJzkSellerActivityPresenter<IActivityTestView, IActivityTestModule> {

    }

    interface IActivityTestModule
            extends IMainLibActivityContract.IMainLibActivityModule {

    }
}
