package seki.com.studydagger2.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import seki.com.studydagger2.MainActivity
import seki.com.studydagger2.MyApp
import seki.com.studydagger2.data.repository.Repository
import seki.com.studydagger2.di.qualifier.DataRepositoryQualifier
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        fun appModule(appModule: AppModule): Builder
    }

    fun appSubComponent(): AppSubComponent.Builder

    fun inject(app: MyApp)
}