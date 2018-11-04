package seki.com.studydagger2.di

import dagger.Component
import seki.com.studydagger2.MainActivity
import seki.com.studydagger2.data.repository.Repository
import seki.com.studydagger2.di.qualifier.DataRepositoryQualifier
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    @DataRepositoryQualifier
    fun getRepository(): Repository
}