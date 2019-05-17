package com.example.history_project_rxjava.ui.info

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.history_project_rxjava.R
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        val intent=intent
        info_place_tv.setText(intent.getStringExtra("name"))
    }
}
