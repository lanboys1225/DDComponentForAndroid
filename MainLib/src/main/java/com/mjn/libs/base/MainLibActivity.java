package com.mjn.libs.base;

import com.bing.lan.comm.mvp.activity.BaseActivity;

/**
 * @author 蓝兵
 */
public abstract class MainLibActivity
        <T extends IMainLibActivityContract.IJzkSellerActivityPresenter>
        extends BaseActivity<T>
        implements IMainLibActivityContract.IJzkSellerActivityView<T> {


}
