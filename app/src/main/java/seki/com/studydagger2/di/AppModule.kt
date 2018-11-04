package seki.com.studydagger2.di

import dagger.Module
import dagger.Provides
import seki.com.studydagger2.data.DataRepository
import seki.com.studydagger2.data.local.DataDao
import seki.com.studydagger2.data.local.LocalDataSource
import seki.com.studydagger2.data.local.LocalSource
import seki.com.studydagger2.data.repository.Repository
import seki.com.studydagger2.data.server.ServerRepository
import seki.com.studydagger2.di.qualifier.DataRepositoryQualifier
import seki.com.studydagger2.di.qualifier.ServerRepositoryQualifier

@Module
class AppModule(val data: String) {

    @Provides
    fun provideDataDao(): DataDao = DataDao(data)

    @Provides
    fun provideLocalDataSource(dao: DataDao): LocalDataSource = LocalSource(dao)

    @Provides
    @ServerRepositoryQualifier
    fun provideServerRepository(): Repository = ServerRepository()

    @Provides
    @DataRepositoryQualifier
    fun provideRepository(
        localDataSource: LocalDataSource,
        @ServerRepositoryQualifier serverRepository: Repository
    ): Repository = DataRepository(localDataSource, serverRepository)
}