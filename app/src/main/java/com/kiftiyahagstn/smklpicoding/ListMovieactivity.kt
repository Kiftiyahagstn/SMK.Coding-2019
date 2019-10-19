package com.kiftiyahagstn.smklpicoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_movieactivity.*
import org.jetbrains.anko.support.v4.viewPager

class ListMovieactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movieactivity)

        ViewPager.adapter=
            TabLayoutAdapter(supportFragmentManager,this)
        tablayout.setupWithViewPager(ViewPager)
    }
}
