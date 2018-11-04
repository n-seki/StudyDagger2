package seki.com.studydagger2

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import seki.com.studydagger2.di.AppComponent
import seki.com.studydagger2.di.AppModule
import seki.com.studydagger2.di.DaggerAppComponent
import javax.inject.Inject

class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .appModule(AppModule("dagger is not easy!"))
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> =
        activityDispatchingAndroidInjector

}