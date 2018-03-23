package com.mjn.libs.base;

import com.bing.lan.comm.mvp.activity.BaseActivity;

/**
 * @author 蓝兵
 */
public abstract class MainLibActivity
        <T extends IMainLibActivityContract.IMainLibActivityPresenter>
        extends BaseActivity<T>
        implements IMainLibActivityContract.IMainLibActivityView<T> {


}
