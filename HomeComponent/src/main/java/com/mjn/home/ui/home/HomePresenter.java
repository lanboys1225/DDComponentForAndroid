package com.mjn.home.ui.home;

import com.mjn.libs.base.MainLibFragmentPresenter;

import static com.mjn.libs.cons.RequestActionCons.ACTION_UPDATE_HOME;

/**
 * @author 蓝兵
 */
public class HomePresenter extends
        MainLibFragmentPresenter<IHomeContract.IHomeView, IHomeContract.IHomeModule>
        implements IHomeContract.IHomePresenter {

    @Override
    public void onStart(Object... params) {

    }

    @Override
    public void updateHome(String userId) {
        showProgressDialog("");
        requestData(ACTION_UPDATE_HOME, userId);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(int action, Object data) {
        super.onSuccess(action, data);
        switch (action) {
        }
        log.i("onSuccess(): " + data.toString());
    }

    @Override
    public void onError(int action, Throwable e) {
        super.onError(action, e);
    }

    @Override
    public void onCompleted(int action) {
        super.onCompleted(action);
    }
}
