package com.mjn.home;

import android.support.v4.app.Fragment;

import com.mjn.home.ui.home.HomeFragment;
import com.mjn.libs.comm.service.HomeService;

/**
 * Created by 蓝兵 on 2018/3/21.
 */

public class HomeServiceImpl implements HomeService {

    @Override
    public Fragment getHomeFragment() {
        return HomeFragment.newInstance("主页Fragment");
    }
}
