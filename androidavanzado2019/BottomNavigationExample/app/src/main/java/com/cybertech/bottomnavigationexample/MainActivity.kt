package com.cybertech.bottomnavigationexample

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.cybertech.pagerexample.adapter.MainAdapter
import com.cybertech.pagerexample.fragments.DetailFragment
import com.cybertech.pagerexample.fragments.FavoritesFragment
import com.cybertech.pagerexample.fragments.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var previewMenuItem: MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val mainAdapter = MainAdapter(initFragments(), supportFragmentManager)
        mainViewPager.adapter = mainAdapter

        mainBottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home_item -> {
                    mainViewPager.currentItem = 0
                    true
                }
                R.id.detail_item -> {
                    mainViewPager.currentItem = 1
                    true
                }
                R.id.favorite_item -> {
                    mainViewPager.currentItem = 2
                    true
                }
                R.id.home_two_item -> {
                    mainViewPager.currentItem = 3
                    true
                }
                else -> {
                    false
                }
            }
        }

        mainViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                if(::previewMenuItem.isInitialized)
                    previewMenuItem.setChecked(false)
                else
                    mainBottomNavigationView.menu.getItem(0).setChecked(false)

                mainBottomNavigationView.menu.getItem(position).setChecked(true)
                previewMenuItem=mainBottomNavigationView.menu.getItem(position)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initFragments(): ArrayList<Fragment> {
        return arrayListOf(
            HomeFragment.newInstance("Home", "#FFFFFF"),
            DetailFragment.newInstance(),
            FavoritesFragment.newInstance(),
            HomeFragment.newInstance("Home2", "#000000")
        )
    }
}
