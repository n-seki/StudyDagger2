package seki.com.studydagger2.data.local

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalSource @Inject constructor(
    private val dao: DataDao
) : LocalDataSource {
    override fun getData(): String = dao.data
    override fun save(data: String) {
        dao.save(data)
    }
}