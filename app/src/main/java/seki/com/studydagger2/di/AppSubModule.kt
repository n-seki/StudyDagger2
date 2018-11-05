package seki.com.studydagger2.di

import dagger.Module
import dagger.Provides
import seki.com.studydagger2.data.AppData

@Module
class AppSubModule {

    @Provides
    fun provideAppData(): AppData = AppData()
}