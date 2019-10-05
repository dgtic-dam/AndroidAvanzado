package com.cybertech.pagerexample.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter


//
// Created by  on 2019-09-21.
//
class MainAdapter(val fragments:ArrayList<Fragment>,fm:FragmentManager):
    FragmentStatePagerAdapter(fm,
    FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}