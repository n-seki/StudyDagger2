package seki.com.studydagger2.di

import dagger.Module
import dagger.Provides
import seki.com.studydagger2.data.repository.Repository
import seki.com.studydagger2.di.qualifier.DataRepositoryQualifier
import seki.com.studydagger2.ui.main.SimpleMainViewModel

@Module
class ActivityModule {

    @Provides
    fun provideViewModel(
        @DataRepositoryQualifier repository: Repository
    ): SimpleMainViewModel
            = SimpleMainViewModel(repository)
}