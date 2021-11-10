package com.zinoview.tzimagesurlapp.presentation.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zinoview.tzimagesurlapp.R
import com.zinoview.tzimagesurlapp.presentation.navigation.ExitActivity
import com.zinoview.tzimagesurlapp.presentation.fragment.ImagesFragment

fun Any?.log(message: String) {
    Log.d("zinoviewk",message)
}

class MainActivity : AppCompatActivity(), ExitActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ImagesFragment())
            .commit()
    }

    override fun onBackPressed() {
        val baseFragment = supportFragmentManager.fragments[0] as BaseFragment
        baseFragment.navigateToBack()
    }

    override fun exit() = finish()
}