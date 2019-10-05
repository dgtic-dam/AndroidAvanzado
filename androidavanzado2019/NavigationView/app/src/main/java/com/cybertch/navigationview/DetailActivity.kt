package com.cybertch.navigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cybertch.navigationview.fragments.HomeFragment

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

            supportFragmentManager.beginTransaction().add(R.id.contentDetail,HomeFragment
                .newInstance("",""),"HOME")
                .commit()

    }
}
