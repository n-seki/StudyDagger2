package seki.com.studydagger2.data.local

import seki.com.studydagger2.data.repository.Repository

interface LocalDataSource : Repository {
    fun save(data: String)
}