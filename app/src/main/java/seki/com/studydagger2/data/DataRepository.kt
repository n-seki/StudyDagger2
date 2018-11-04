package seki.com.studydagger2.data

import seki.com.studydagger2.data.local.LocalDataSource
import seki.com.studydagger2.data.repository.Repository
import seki.com.studydagger2.di.qualifier.ServerRepositoryQualifier
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val netDataSource: Repository
) : Repository {

    private var dirty: Boolean = false

    override fun getData(): String {
        if (!dirty) {
            return localDataSource.getData()
        }

        val newData = netDataSource.getData()
        localDataSource.save(newData)
        dirty = false
        return newData
    }
}