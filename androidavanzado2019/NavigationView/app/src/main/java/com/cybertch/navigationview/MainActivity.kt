package com.cybertch.navigationview

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.cybertch.navigationview.fragments.ConfigurationFragment
import com.cybertch.navigationview.fragments.FavoriteFragment
import com.cybertch.navigationview.fragments.HomeFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.container_main.*
import kotlinx.android.synthetic.main.header.view.*
import kotlinx.android.synthetic.main.toolbar.*


class MainActivity : AppCompatActivity() ,NavigationView
.OnNavigationItemSelectedListener{

    val homeFragment=HomeFragment.newInstance("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(android.R.drawable.ic_menu_view)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this,
            mainDrawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer)
        mainDrawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        mainNavigationView.setNavigationItemSelectedListener(this)

        val header=mainNavigationView.getHeaderView(0)
        header.titleHeaderTextView.setText("Hola Mundo")

        supportFragmentManager.beginTransaction().add(R.id.contentMain,
            homeFragment,"HOME").commit()

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
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

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        return when(p0.itemId){
            R.id.homeItem->{
                supportFragmentManager.popBackStack()
                mainDrawerLayout.closeDrawers()
                true
            }
            R.id.favoriteItem->{
                switchFragment(R.id.contentMain,FavoriteFragment
                    .newInstance("",""),"FAVORITE")
                mainDrawerLayout.closeDrawers()
                true
            }
            R.id.configuration_item->{
                switchFragment(R.id.contentMain,ConfigurationFragment
                    .newInstance("",""),"CONFIG")
                mainDrawerLayout.closeDrawers()
                true
            }
            R.id.aboutItem->{
                val detailIntent= Intent(this,DetailActivity::class.java)
                startActivity(detailIntent)
                true
            }
            R.id.privacyItem->{
                true
            }
            else ->{
                true
            }

        }
    }

    fun switchFragment(idContainer:Int, fragment: Fragment, tag:String){
        if(fragment!=null){
            while (supportFragmentManager.popBackStackImmediate()){}
            val fragmentTransaction=supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(idContainer,fragment)
            if(!(fragment is HomeFragment))
                fragmentTransaction.addToBackStack(tag)
            fragmentTransaction.commit()
        }
    }
}
