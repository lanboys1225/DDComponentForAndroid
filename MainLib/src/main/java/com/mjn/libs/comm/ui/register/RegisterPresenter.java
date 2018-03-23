package com.mjn.libs.comm.ui.register;

import com.mjn.libs.api.ResponseResult;
import com.mjn.libs.base.vcode.GetVcodePresenter;
import com.mjn.libs.comm.bean.UserBean;

import static com.mjn.libs.cons.RequestActionCons.ACTION_REGISTER;

/**
 * @author 蓝兵
 */
public class RegisterPresenter
        extends GetVcodePresenter<IRegisterContract.IRegisterView, IRegisterContract.IRegisterModule>
        implements IRegisterContract.IRegisterPresenter {

    @Override
    public void onStart(Object... params) {
    }

    @Override
    public void register(String mobile, String password, String authCode, String inviteCode) {
        showProgressDialog("");
        requestData(ACTION_REGISTER, mobile, password, authCode, inviteCode);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void onSuccess(int action, Object data) {
        super.onSuccess(action, data);

        //处理验证码结果
        handleVcode(action, data);

        switch (action) {
            case ACTION_REGISTER:
                ResponseResult<UserBean> httpResult = (ResponseResult<UserBean>) data;
                String errorCode = httpResult.getCode();
                if (ResponseResult.REQUEST_CODE_SUCCESS.equals(errorCode)) {
                    mView.registerSuccess(httpResult.getData().getList().get(0));
                } else {
                    showError(httpResult.getMessage());
                }
                break;
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
