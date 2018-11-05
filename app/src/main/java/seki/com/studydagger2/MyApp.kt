package seki.com.studydagger2

import android.app.Activity
import android.app.Application
import android.widget.Toast
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import seki.com.studydagger2.di.AppModule
import seki.com.studydagger2.di.AppSubModule
import seki.com.studydagger2.di.DaggerAppComponent
import javax.inject.Inject

class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.builder()
            .appModule(AppModule("dagger is not easy!"))
            .build()

        appComponent.inject(this)

        val appData = appComponent.appSubComponent()
            .module(AppSubModule())
            .build()
            .appData()

        Toast.makeText(this, appData.getAppData(), Toast.LENGTH_SHORT).show()
    }

    override fun activityInjector(): AndroidInjector<Activity> =
        activityDispatchingAndroidInjector

}