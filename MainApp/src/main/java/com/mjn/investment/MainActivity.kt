package com.mjn.investment

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.luojilab.component.componentlib.router.Router
import com.mjn.libs.comm.service.HomeService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)


        val router = Router.getInstance()
        if (router.getService(HomeService::class.java!!.getSimpleName()) != null) {
            val service = router.getService(HomeService::class.java!!.getSimpleName()) as HomeService
            var fragment = service.homeFragment
            var ft = supportFragmentManager.beginTransaction()
            ft.add(R.id.tab_content, fragment).commitAllowingStateLoss()

        }

    }


}
