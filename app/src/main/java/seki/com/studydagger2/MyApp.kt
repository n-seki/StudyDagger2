package seki.com.studydagger2

import android.app.Activity
import android.app.Application
import android.widget.Toast
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import seki.com.studydagger2.data.Color
import seki.com.studydagger2.di.AppModule
import seki.com.studydagger2.di.AppSubModule
import seki.com.studydagger2.di.DaggerAppComponent
import seki.com.studydagger2.di.MultibindingsModule
import javax.inject.Inject
import javax.inject.Provider

class MyApp : Application(), HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var stringSet: Set<String>

    @Inject
    lateinit var stringLongMap: Map<String, Long>

    @Inject
    lateinit var tableStringMap: Map<Class<*>, String>

    @Inject
    @JvmSuppressWildcards
    lateinit var colorStringMap: Map<Color, Provider<String>>

    override fun onCreate() {
        super.onCreate()

        val appComponent = DaggerAppComponent.builder()
            .multibindingsModule(MultibindingsModule())
            .appModule(AppModule("dagger is not easy!"))
            .build()

        appComponent.inject(this)

        val appData = appComponent.appSubComponent()
            .module(AppSubModule())
            .build()
            .appData()

        Toast.makeText(this, appData.getAppData(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, stringLongMap.toString(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, stringSet.toString(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this, tableStringMap.toString(), Toast.LENGTH_SHORT).show()
        Toast.makeText(this,  colorStringMap.toString(), Toast.LENGTH_SHORT).show()
    }

    override fun activityInjector(): AndroidInjector<Activity> =
        activityDispatchingAndroidInjector

}