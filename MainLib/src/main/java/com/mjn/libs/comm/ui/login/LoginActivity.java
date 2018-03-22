package com.mjn.libs.comm.ui.login;

import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bing.lan.comm.view.MyToolbar;
import com.mjn.libs.R;
import com.mjn.libs.base.MainLibActivity;

/**
 * @author 蓝兵
 */
public class LoginActivity extends MainLibActivity<ILoginContract.ILoginPresenter>
        implements ILoginContract.ILoginView {

    ////@BindView(R.id.toolbar)
    ////@BindView(R2.id.toolbar)
    //MyToolbar mToolbar;
    private android.widget.LinearLayout mLoginContainer;
    private android.widget.ImageView mImageView3;
    private android.widget.EditText mLoginAccountEt;
    private android.widget.ImageView mIvDeletephone;
    private android.widget.LinearLayout mLinearLayout;
    private android.widget.ImageView mImageView4;
    private android.widget.EditText mLoginPasswordEt;
    private android.widget.ImageView mIvDeletepwd;
    private android.widget.TextView mLoginLoginBtn;
    private android.widget.TextView mLoginRegistBtn;
    private android.widget.TextView mLoginFindPwdBtn;
    private MyToolbar mToolbar;

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
        initView();
        setToolBar(mToolbar, "登录页面", true, 0);
    }

    @Override
    protected void readyStartPresenter() {

    }

    private void initView() {
        mLoginContainer = (LinearLayout) findViewById(R.id.login_container);
        mImageView3 = (ImageView) findViewById(R.id.imageView3);
        mLoginAccountEt = (EditText) findViewById(R.id.login_accountEt);
        mIvDeletephone = (ImageView) findViewById(R.id.iv_deletephone);
        mLinearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mImageView4 = (ImageView) findViewById(R.id.imageView4);
        mLoginPasswordEt = (EditText) findViewById(R.id.login_passwordEt);
        mIvDeletepwd = (ImageView) findViewById(R.id.iv_deletepwd);
        mLoginLoginBtn = (TextView) findViewById(R.id.login_loginBtn);
        mLoginRegistBtn = (TextView) findViewById(R.id.login_registBtn);
        mLoginFindPwdBtn = (TextView) findViewById(R.id.login_findPwdBtn);
        mToolbar = (MyToolbar) findViewById(R.id.toolbar);
    }
}
