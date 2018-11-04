package seki.com.studydagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import dagger.android.AndroidInjection
import seki.com.studydagger2.ui.main.MainFragment
import seki.com.studydagger2.ui.main.SimpleMainViewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SimpleMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        AndroidInjection.inject(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow()
        }

        Toast.makeText(this, viewModel.getShowText(), Toast.LENGTH_SHORT).show()
    }

}
