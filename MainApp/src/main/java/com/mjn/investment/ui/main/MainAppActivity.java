package com.mjn.investment.ui.main;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.bing.lan.comm.view.MyToolbar;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.service.AutowiredService;
import com.luojilab.router.facade.annotation.Autowired;
import com.luojilab.router.facade.annotation.RouteNode;
import com.mjn.investment.R;
import com.mjn.libs.base.MainLibActivity;
import com.mjn.libs.comm.service.HomeService;
import com.mjn.libs.cons.UIRouterCons;

import butterknife.BindView;

/**
 * @author 蓝兵
 */

@RouteNode(path = UIRouterCons.MAIN_APP_ROUTE_NODE_PATH,
        desc = UIRouterCons.MAIN_APP_ROUTE_NODE_DESC)
public class MainAppActivity extends MainLibActivity<IMainAppContract.IMainAppPresenter>
        implements IMainAppContract.IMainAppView {

    @Autowired(name = UIRouterCons.MAIN_APP_AUTOWIRED_NAME,
            desc = UIRouterCons.MAIN_APP_AUTOWIRED_DESC)
    String mBookName;

    @BindView(R.id.toolbar)
    MyToolbar mToolbar;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main_app;
    }

    @Override
    protected IMainAppContract.IMainAppPresenter initPresenter() {
        MainAppPresenter presenter = new MainAppPresenter();
        presenter.setModule(new MainAppModule());
        presenter.onAttachView(this);
        return presenter;
    }

    @Override
    protected void initViewAndData(Intent intent) {
        setToolBar(mToolbar, "包公有财首页", true, 0);
    }

    @Override
    protected void readyStartPresenter() {

        AutowiredService.Factory.getInstance().create().autowire(this);

        Router router = Router.getInstance();
        if (router.getService(HomeService.class.getSimpleName()) != null) {
            HomeService service = (HomeService) router.getService(HomeService.class.getSimpleName());
            Fragment fragment = service.getHomeFragment();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();

            Log.i("onCreate():", " -----------------------");
        }
    }
}
