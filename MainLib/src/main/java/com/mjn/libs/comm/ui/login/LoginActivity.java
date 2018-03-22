package com.mjn.libs.comm.ui.login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bing.lan.comm.view.MyToolbar;
import com.mjn.libs.R;
import com.mjn.libs.base.MainLibActivity;
import com.mjn.libs.utils.AppUtil1;

/**
 * @author 蓝兵
 */
public class LoginActivity extends MainLibActivity<ILoginContract.ILoginPresenter>
        implements ILoginContract.ILoginView, View.OnClickListener {

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

    private void initView() {
        mToolbar = (MyToolbar) findViewById(R.id.toolbar);
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

        mLoginLoginBtn.setOnClickListener(this);

        mLoginAccountEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mIvDeletephone.setVisibility(View.VISIBLE);
                    mIvDeletepwd.setVisibility(View.GONE);
                } else {
                    mIvDeletephone.setVisibility(View.GONE);
                    mIvDeletepwd.setVisibility(View.GONE);
                }
            }
        });

        mLoginPasswordEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mIvDeletepwd.setVisibility(View.VISIBLE);
                    mIvDeletephone.setVisibility(View.GONE);
                } else {
                    mIvDeletepwd.setVisibility(View.GONE);
                    mIvDeletephone.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void initViewAndData(Intent intent) {
        initView();
        setToolBar(mToolbar, "登录", true, R.drawable.icon_invite_friend_close);
    }

    @Override
    protected void readyStartPresenter() {

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.login_loginBtn) {
            if (TextUtils.isEmpty(mLoginAccountEt.getText().toString())) {
                showError("请填写账号");
            } else if (TextUtils.isEmpty(mLoginPasswordEt.getText().toString())) {
                showError("请填写密码");
            } else if (!AppUtil1.checkPwd(mLoginPasswordEt.getText().toString())) {
                showError("请输入6-12位字母数字组合密码");
            } else {
                mPresenter.login(
                        mLoginAccountEt.getText().toString(),
                        mLoginPasswordEt.getText().toString()
                );
            }
        } else if (id == R.id.login_registBtn) {

        }
    }
}
