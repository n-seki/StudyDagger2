package seki.com.studydagger2.di

import dagger.Subcomponent
import seki.com.studydagger2.data.AppData

@Subcomponent(modules = [AppSubModule::class])
interface AppSubComponent {

    fun appData(): AppData

    @Subcomponent.Builder
    interface Builder {
        fun module(appSubModule: AppSubModule): Builder
        fun build(): AppSubComponent
    }
}