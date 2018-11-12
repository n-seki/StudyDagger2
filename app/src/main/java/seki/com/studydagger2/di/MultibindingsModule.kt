package seki.com.studydagger2.di

import dagger.Module
import dagger.Provides
import dagger.multibindings.*
import seki.com.studydagger2.data.Color
import seki.com.studydagger2.data.Table
import seki.com.studydagger2.di.key.MyColorKey

@Module
class MultibindingsModule {

    @Provides
    @IntoSet
    fun provideOneString(): String = "ABC"

    @Provides
    @ElementsIntoSet
    fun provideStringSet(): Set<String> =
            setOf(
                "DEF",
                "GHI"
            )

    @Provides
    @IntoMap
    @StringKey("foo")
    fun provideFooValue(): Long = 123

    @Provides
    @IntoMap
    @ClassKey(Table::class)
    fun provideTableValue(): String = "value to table"

    @Provides
    @IntoMap
    @MyColorKey(Color.RED)
    fun provideRedValue(): String = "value for red"

    @Provides
    @IntoMap
    @MyColorKey(Color.BLUE)
    fun provideBlueValue(): String = "value for blue"
}