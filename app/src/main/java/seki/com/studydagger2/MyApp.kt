package seki.com.studydagger2

import android.app.Application
import seki.com.studydagger2.di.AppComponent
import seki.com.studydagger2.di.AppModule
import seki.com.studydagger2.di.DaggerAppComponent

class MyApp : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule("dagger is not easy!"))
            .build()
    }
}