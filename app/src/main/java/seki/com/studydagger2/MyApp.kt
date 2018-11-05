package seki.com.studydagger2

import android.app.Activity
import android.app.Application
import android.widget.Toast
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import seki.com.studydagger2.data.AppData
import seki.com.studydagger2.di.*
import javax.inject.Inject
import javax.inject.Provider

class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var subComponentBuilder: Provider<AppSubComponent.Builder>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .appModule(AppModule("dagger is not easy!"))
            .build()
            .inject(this)

        val appData = subComponentBuilder.get()
            .module(AppSubModule())
            .build()
            .appData()

        Toast.makeText(this, appData.getAppData(), Toast.LENGTH_SHORT).show()
    }

    override fun activityInjector(): AndroidInjector<Activity> =
        activityDispatchingAndroidInjector

}