package com.mjn.home.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.bing.lan.comm.app.AppUtil;
import com.mjn.home.R;
import com.mjn.home.R2;
import com.mjn.libs.base.MainLibFragment;
import com.mjn.libs.comm.ui.login.LoginActivity;

import butterknife.BindView;

/**
 * @author 蓝兵
 */
public class HomeFragment extends MainLibFragment<IHomeContract.IHomePresenter>
        implements IHomeContract.IHomeView {

    public HomeFragment() {

    }

    @BindView(R2.id.btn_login)
    Button mBtnLogin;

    public static HomeFragment newInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        fragment.setTitle(title);
        return fragment;
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_home;
    }

    @Override
    protected IHomeContract.IHomePresenter initPresenter() {
        HomePresenter presenter = new HomePresenter();
        presenter.setModule(new HomeModule());
        presenter.onAttachView(this);
        return presenter;
    }

    // @Override
    // protected void startInject(FragmentComponent fragmentComponent) {
    //     //        fragmentComponent.inject(this);
    // }

    @Override
    protected void initViewAndData(Intent intent, Bundle arguments) {

    }

    @Override
    protected void readyStartPresenter() {
        //mBtnLogin = mContentView.findViewById(R.id.btn_login);


        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AppUtil.getAppContext(), "点我登录", Toast.LENGTH_SHORT).show();
                startActivity(LoginActivity.class, false, true);
            }
        });
    }
}
