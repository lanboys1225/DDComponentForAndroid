package com.mjn.home.ui.home;

import com.mjn.libs.base.IMainLibFragmentContract;

/**
 * @author 蓝兵
 */
public interface IHomeContract {

    interface IHomeView extends IMainLibFragmentContract.IMainLibFragmentView<IHomePresenter> {

    }

    interface IHomePresenter extends
            IMainLibFragmentContract.IMainLibFragmentPresenter<IHomeView, IHomeModule> {

    }

    interface IHomeModule extends IMainLibFragmentContract.IJzkSellerFragmentModule {

    }
}
