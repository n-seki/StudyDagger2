package seki.com.studydagger2.di.key

import dagger.MapKey
import seki.com.studydagger2.data.Color

@MapKey
annotation class MyColorKey(val color: Color)