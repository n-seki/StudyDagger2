package seki.com.studydagger2.ui.main

import seki.com.studydagger2.data.repository.Repository
import javax.inject.Inject

class SimpleMainViewModel @Inject constructor(
    val repository: Repository
) {

    fun getShowText(): String = repository.getData()
}