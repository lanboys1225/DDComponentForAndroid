package com.mjn.libs.comm.ui.login;

import android.content.Intent;

import com.bing.lan.comm.view.MyToolbar;
import com.mjn.libs.R;
import com.mjn.libs.R2;
import com.mjn.libs.base.MainLibActivity;

import butterknife.BindView;

/**
 * @author 蓝兵
 */
public class LoginActivity extends MainLibActivity<ILoginContract.ILoginPresenter>
        implements ILoginContract.ILoginView {

    @BindView(R2.id.toolbar)
    MyToolbar mToolbar;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_login;
    }

    @Override
    protected ILoginContract.ILoginPresenter initPresenter() {
        LoginPresenter presenter = new LoginPresenter();
        presenter.setModule(new LoginModule());
        presenter.onAttachView(this);
        return presenter;
    }

    @Override
    protected void initViewAndData(Intent intent) {
        //mToolbar = findViewById(R.id.toolbar);

        setToolBar(mToolbar, "登录页面", true, 0);
    }

    @Override
    protected void readyStartPresenter() {

    }
}
