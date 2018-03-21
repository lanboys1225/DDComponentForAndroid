package com.mjn.discover.applike;

import com.luojilab.component.componentlib.applicationlike.IApplicationLike;
import com.luojilab.component.componentlib.router.Router;
import com.luojilab.component.componentlib.router.ui.UIRouter;
import com.mjn.discover.DiscoverServiceImpl;
import com.mjn.libs.comm.service.DiscoverService;
import com.mjn.libs.comm.service.HomeService;

public class DiscoverAppLike implements IApplicationLike {

    Router router = Router.getInstance();
    UIRouter uiRouter = UIRouter.getInstance();

    @Override
    public void onCreate() {
        uiRouter.registerUI("discover");
        router.addService(DiscoverService.class.getSimpleName(), new DiscoverServiceImpl());
    }

    @Override
    public void onStop() {
        uiRouter.unregisterUI("discover");
        router.removeService(HomeService.class.getSimpleName());
    }
}
