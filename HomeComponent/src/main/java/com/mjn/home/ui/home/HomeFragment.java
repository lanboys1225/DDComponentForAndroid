package com.mjn.home.ui.home;

import android.content.Intent;
import android.os.Bundle;

import com.mjn.home.R;
import com.mjn.libs.base.MainLibFragment;

/**
 * @author 蓝兵
 */
public class HomeFragment extends MainLibFragment<IHomeContract.IHomePresenter>
        implements IHomeContract.IHomeView {

    public HomeFragment() {

    }

    public static HomeFragment newInstance(String title) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("fragment标题", title);
        fragment.setArguments(args);
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

    }
}
