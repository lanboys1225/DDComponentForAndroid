package com.mjn.home.ui.home;

import com.mjn.libs.base.IMainLibFragmentContract;

/**
 * @author 蓝兵
 */
public interface IHomeContract {

    interface IHomeView extends IMainLibFragmentContract.IMainLibFragmentView<IHomePresenter> {

        void onUpdateSuccess();
    }

    interface IHomePresenter extends
            IMainLibFragmentContract.IMainLibFragmentPresenter<IHomeView, IHomeModule> {

        void updateHome(String userId);
    }

    interface IHomeModule extends IMainLibFragmentContract.IJzkSellerFragmentModule {

    }
}
