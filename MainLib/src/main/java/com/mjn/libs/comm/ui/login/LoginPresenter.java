package com.mjn.libs.comm.ui.login;

import com.mjn.libs.base.MainLibActivityPresenter;

/**
 * @author 蓝兵
 */
public class LoginPresenter
        extends MainLibActivityPresenter<ILoginContract.ILoginView, ILoginContract.ILoginModule>
        implements ILoginContract.ILoginPresenter {

    @Override
    public void onStart(Object... params) {
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(int action, Object data) {
        super.onSuccess(action, data);
        switch (action) {
        }
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
