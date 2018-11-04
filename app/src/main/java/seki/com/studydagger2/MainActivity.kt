package seki.com.studydagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import seki.com.studydagger2.data.repository.Repository
import seki.com.studydagger2.di.AppModule
import seki.com.studydagger2.di.DaggerAppComponent
import seki.com.studydagger2.di.qualifier.DataRepositoryQualifier
import seki.com.studydagger2.ui.main.MainFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @field:[Inject DataRepositoryQualifier]
    lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        DaggerAppComponent.builder()
            .appModule(AppModule("dagger is difficult!"))
            .build()
            .inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        Toast.makeText(this, repository.getData(), Toast.LENGTH_SHORT).show()
    }

}
