package com.mjn.libs.base;

import com.bing.lan.comm.mvp.fragment.BaseFragment;

/**
 * @author 蓝兵
 */
public abstract class MainLibFragment
        <T extends IMainLibFragmentContract.IMainLibFragmentPresenter>
        extends BaseFragment<T>
        implements IMainLibFragmentContract.IMainLibFragmentView<T> {


}
