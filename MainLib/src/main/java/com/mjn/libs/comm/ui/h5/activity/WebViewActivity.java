package com.mjn.libs.comm.ui.h5.activity;

import android.app.Fragment;
import android.content.Intent;
import android.view.KeyEvent;

import com.bing.lan.comm.view.MyToolbar;
import com.mjn.libs.R;
import com.mjn.libs.base.MainLibActivity;
import com.mjn.libs.comm.ui.h5.fragment.Html5Fragment;

/**
 * @author 蓝兵
 */
public class WebViewActivity extends MainLibActivity<IWebViewContract.IWebViewPresenter>
        implements IWebViewContract.IWebViewView {

    MyToolbar mToolbar;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_web_view;
    }

    @Override
    protected IWebViewContract.IWebViewPresenter initPresenter() {
        WebViewPresenter presenter = new WebViewPresenter();
        presenter.setModule(new WebViewModule());
        presenter.onAttachView(this);
        return presenter;
    }

    @Override
    protected void initViewAndData(Intent intent) {
        mToolbar = findViewById(R.id.toolbar);
        setToolBar(mToolbar, "Html5页面", true, 0);
    }

    @Override
    protected void readyStartPresenter() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Html5Fragment html5Fragment = findViewById(R.id.webView_fragment);
        if (html5Fragment != null) {
            if (html5Fragment.onKeyDown(keyCode, event)) {
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
