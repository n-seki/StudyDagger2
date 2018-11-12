package seki.com.studydagger2.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import seki.com.studydagger2.MyApp
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        MultibindingsModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun multibindingsModule(multibindingsModule: MultibindingsModule): Builder
        fun appModule(appModule: AppModule): Builder
        fun build(): AppComponent
    }

    fun appSubComponent(): AppSubComponent.Builder

    fun inject(app: MyApp)
}