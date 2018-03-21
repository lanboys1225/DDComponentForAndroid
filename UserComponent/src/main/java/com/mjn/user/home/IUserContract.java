package com.mjn.user.home;

import com.mjn.libs.base.IMainLibFragmentContract;

/**
 * @author 蓝兵
 */
public interface IUserContract {

    interface IUserView extends IMainLibFragmentContract.IMainLibFragmentView<IUserPresenter> {

    }

    interface IUserPresenter extends
            IMainLibFragmentContract.IMainLibFragmentPresenter<IUserView, IUserModule> {

    }

    interface IUserModule extends IMainLibFragmentContract.IJzkSellerFragmentModule {

    }
}
