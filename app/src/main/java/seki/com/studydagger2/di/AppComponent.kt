package seki.com.studydagger2.di

import dagger.Component
import seki.com.studydagger2.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}