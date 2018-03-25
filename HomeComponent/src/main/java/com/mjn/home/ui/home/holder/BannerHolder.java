package com.mjn.home.ui.home.holder;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.bing.lan.comm.adapter.BaseViewHolder;
import com.mjn.home.R;
import com.mjn.home.ui.home.adapter.BannerAdapter;
import com.mjn.libs.comm.bean.Adv;
import com.mjn.home.ui.home.bean.BannerBean;
import com.mjn.libs.utils.AppSpDataUtil;
import com.mjn.libs.utils.SPUtil;
import com.mjn.libs.view.banner.BannerBaseAdapter;
import com.mjn.libs.view.banner.BannerView;

import java.util.List;

/**
 * Created by 蓝兵 on 2018/3/24.
 */

public class BannerHolder extends BaseViewHolder<BannerBean> implements BannerBaseAdapter.OnPageTouchListener<Adv> {

    private final BannerView bannerView;
    private List<Adv> mBannerList;

    public BannerHolder(View itemView) {
        super(itemView);
        bannerView = itemView.findViewById(R.id.bannerView);
    }

    @Override
    public void fillData(BannerBean data, int position) {
        mBannerList = data.getBannerList();
        BannerAdapter mAdapter = new BannerAdapter(com.bing.lan.comm.app.AppUtil.getAppContext());
        bannerView.setAdapter(mAdapter);
        mAdapter.setOnPageTouchListener(this);
    }

    @Override
    public void onPageClick(int position, Adv adv) {
        // 页面点击
        if (mBannerList.isEmpty())
            return;
        if (mBannerList.get(position).getNeedLogin() == 0) {
            if (!mBannerList.isEmpty() && position < mBannerList.size() &&
                    !TextUtils.isEmpty(mBannerList.get(position).getDestUrl())) {
                Bundle bundle = new Bundle();

                // 判断是否登录，登录传token,userid,isoginq=1.未登录只传递isLogin
                if (AppSpDataUtil.getInstance().isLogined()) {
                    // 拼接参数用？还是&的区分
                    if (mBannerList.get(position).getDestUrl().contains("?")) {
                        bundle.putString("url", mBannerList.get(position).getDestUrl() + "&token=" + SPUtil.getInstance().getString("token") + "&userId=" + AppSpDataUtil.getInstance().getUserBean().getUserId() + "&isLogin=1");
                    } else {
                        bundle.putString("url", mBannerList.get(position).getDestUrl() + "?token=" + SPUtil.getInstance().getString("token") + "&userId=" + AppSpDataUtil.getInstance().getUserBean().getUserId() + "&isLogin=1");
                    }
                } else {
                    if (mBannerList.get(position).getDestUrl().contains("?")) {
                        bundle.putString("url", mBannerList.get(position).getDestUrl() + "&isLogin=0");
                    } else {
                        bundle.putString("url", mBannerList.get(position).getDestUrl() + "?isLogin=0");
                    }
                }

                bundle.putString("title", mBannerList.get(position).getAdvTxt());
                //Tools.pushScreen(HybridOfWebview.class, bundle);
            }
        } else {
            // 未登录状态下不可以进入H5
            if (!AppSpDataUtil.getInstance().isLogined()) {
                //Tools.pushScreen(Login.class, null);
            } else {
                if (position < mBannerList.size() && !TextUtils.isEmpty(mBannerList.get(position).getDestUrl())) {
                    Bundle bundle = new Bundle();

                    // 拼接参数用？还是&的区分
                    if (mBannerList.get(position).getDestUrl().contains("?")) {
                        bundle.putString("url", mBannerList.get(position).getDestUrl() + "&token="
                                + SPUtil.getInstance().getString("token") + "&userId="
                                + AppSpDataUtil.getInstance().getUserBean().getUserId() + "&isLogin=1");
                    } else {
                        bundle.putString("url", mBannerList.get(position).getDestUrl() + "?token="
                                + SPUtil.getInstance().getString("token") + "&userId="
                                + AppSpDataUtil.getInstance().getUserBean().getUserId() + "&isLogin=1");
                    }

                    bundle.putString("title", mBannerList.get(position).getAdvTxt());
                    //Tools.pushScreen(HybridOfWebview.class, bundle);
                }
            }
        }
    }

    @Override
    public void onPageDown() {
        if (bannerView != null) {
            // 按下，可以停止轮播
            bannerView.stopAutoScroll();
        }
    }

    @Override
    public void onPageUp() {
        if (bannerView != null) {
            // 抬起开始轮播
            bannerView.startAutoScroll();
            Log.e("bannerView", "start");
        }
    }
}


