package seki.com.studydagger2.data.local

import javax.inject.Inject

class DataDao @Inject constructor(
    var data: String
) {
    fun save(data: String) {
        this.data = data
    }
}