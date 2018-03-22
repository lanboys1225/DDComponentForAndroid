package com.mjn.libs.comm.ui.login;

import com.bing.lan.comm.rx.OnDataChangerListener;
import com.mjn.libs.api.ApiManager;
import com.mjn.libs.api.ResponseResult;
import com.mjn.libs.base.MainLibActivityModule;
import com.mjn.libs.comm.bean.IUser;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;

/**
 * @author 蓝兵
 */
public class LoginModule extends MainLibActivityModule
        implements ILoginContract.ILoginModule {

    @Override
    public void loadData(int action, OnDataChangerListener listener, Object... parameter) {
        super.loadData(action, listener, parameter);

        Map<String, String> params = new HashMap<>();
        checkNotEmptyAdd(params, (String) parameter[0], "mobile");
        checkNotEmptyAdd(params, (String) parameter[1], "password");
        params = handlerRequest(params);


        Observable<ResponseResult<IUser>> observable = ApiManager.getInstance()
                .getApiService()
                .login(params);

        subscribe(observable, action, listener, "登录..");
    }
}
