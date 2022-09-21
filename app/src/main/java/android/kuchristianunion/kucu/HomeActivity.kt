package android.kuchristianunion.kucu

import android.content.Intent
import android.kuchristianunion.kucu.Fragments.Help
import android.kuchristianunion.kucu.Fragments.HomeFragment
import android.kuchristianunion.kucu.Fragments.dashboard
import android.kuchristianunion.kucu.Fragments.profile
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.gauravk.bubblenavigation.BubbleNavigationConstraintView
import com.gauravk.bubblenavigation.BubbleNavigationLinearView

class HomeActivity : AppCompatActivity() {
    lateinit var fragment: Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val homeFragment = HomeFragment()
        val  helpFragment = Help()
        val dashboardFragment = dashboard()
        val profileFragment = profile()

        makeCurrentFragment(homeFragment)
        val bubbleNavigationLayout = findViewById<BubbleNavigationConstraintView>(R.id.bottom_navigation_view_linear)

        bubbleNavigationLayout.setNavigationChangeListener() {
            view, position ->
            when (position) {
                0 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, homeFragment).commit()
                    true

                }
                1 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, dashboardFragment).commit()
                    true
                }
                 2 -> {
                    //startActivity(Intent(this@HomeActivity,BsGuidesActivity::class.java))
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container, profileFragment).commit()
                    true
                }
                3 -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragment_container,helpFragment).commit()
                    true
                }
                else -> false
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.action_settings-> {
                settings()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun settings() {
        TODO("Not yet implemented")

    }

    private fun makeCurrentFragment(homeFragment: HomeFragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, homeFragment).commit()
        }

    }

}