package com.mjn.home.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.mjn.home.R;
import com.mjn.libs.base.MainLibFragment;
import com.mjn.libs.comm.ui.login.LoginActivity;

/**
 * @author 蓝兵
 */
public class HomeFragment extends MainLibFragment<IHomeContract.IHomePresenter>
        implements IHomeContract.IHomeView {

    private android.widget.Button mBtnLogin;

    public HomeFragment() {

    }

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
        initView();
    }

    @Override
    protected void readyStartPresenter() {
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "点我登录", Toast.LENGTH_SHORT).show();
                startActivity(LoginActivity.class, false, true);
            }
        });
    }

    private void initView() {
        mBtnLogin = mContentView.findViewById(R.id.btn_login);
    }
}
