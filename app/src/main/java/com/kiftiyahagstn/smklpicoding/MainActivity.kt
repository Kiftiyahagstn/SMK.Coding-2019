package com.kiftiyahagstn.smklpicoding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_List_movie.onClick {
 //           val intent =
 //               intent (this@MainActivity,ListMovieactivity::class.java)
            startActivity(intentFor<ListMovieactivity>())
        }

        btn_List_Profil.onClick{
            startActivity(intentFor<profil_Activity>())
        }
        btn_List_Favorit_movie.onClick {

        }
        }
        }
