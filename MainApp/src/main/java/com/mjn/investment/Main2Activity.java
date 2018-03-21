package com.mjn.investment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.luojilab.component.componentlib.router.Router;
import com.mjn.libs.comm.service.HomeService;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Router router = Router.getInstance();
        if (router.getService(HomeService.class.getSimpleName()) != null) {
            HomeService service = (HomeService) router.getService(HomeService.class.getSimpleName());
            Fragment fragment = service.getHomeFragment();

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss();

           Log.i("onCreate():"," -----------------------");
        }
    }
}
