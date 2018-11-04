package seki.com.studydagger2.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import seki.com.studydagger2.MainActivity

@Module
interface ActivityBuilder {

    @ContributesAndroidInjector(modules = [ActivityModule::class])
    fun bindMainActivity(): MainActivity
}