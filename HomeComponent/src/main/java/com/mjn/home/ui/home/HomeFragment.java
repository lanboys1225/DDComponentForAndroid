package com.mjn.home.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.ganxin.library.LoadDataLayout;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.mjn.home.R;
import com.mjn.home.ui.home.adapter.HomeRecyclerAdapter;
import com.mjn.libs.comm.bean.IHomeItemBean;
import com.mjn.libs.base.MainLibFragment;
import com.mjn.libs.comm.ui.login.LoginActivity;

import java.util.ArrayList;

/**
 * @author 蓝兵
 */
public class HomeFragment extends MainLibFragment<IHomeContract.IHomePresenter>
        implements IHomeContract.IHomeView {

    private android.widget.Button mBtnLogin;
    private com.bing.lan.comm.view.MyToolbar mToolbar;
    private com.mjn.libs.view.pullRefresh.PullToRefreshLoadDataLayoutRecyclerView mPullRefreshRecycler;
    private LoadDataLayout mLoadDataLayout;
    private RecyclerView mRecyclerView;
    private HomeRecyclerAdapter mAdapter;
    private ArrayList<IHomeItemBean> mList = new ArrayList<>();

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
        mToolbar = mContentView.findViewById(R.id.toolbar);
        mPullRefreshRecycler = mContentView.findViewById(R.id.pull_refresh_recycler);

        mPullRefreshRecycler.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<LoadDataLayout>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<LoadDataLayout> refreshView) {
                mPresenter.updateHome("");
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<LoadDataLayout> refreshView) {
                mPresenter.updateHome("");
            }
        });

        mLoadDataLayout = mPullRefreshRecycler.getRefreshableView();
        mRecyclerView = mPullRefreshRecycler.getRealRefreshableView();

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new HomeRecyclerAdapter();
        mAdapter.setDataAndRefresh(mList);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onUpdateSuccess() {
        mPullRefreshRecycler.onRefreshComplete();
    }
}
