package seki.com.studydagger2.di

import dagger.Component
import seki.com.studydagger2.MainActivity
import seki.com.studydagger2.di.scope.PerActivity

@PerActivity
@Component(dependencies = [AppComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(mainActivity: MainActivity)
}