package seki.com.studydagger2.data.server

import seki.com.studydagger2.data.repository.Repository
import javax.inject.Singleton

@Singleton
class ServerRepository : Repository {
    override fun getData(): String = "sample-from-server"
}