package com.tjr.alim.profilmhs

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tjr.alim.profilmhs.ui.activity.DataActivity
import kotlinx.android.synthetic.main.activity_hal_utama.*

class ActivityAwal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hal_utama)

        keberanda.setOnClickListener {
            val cus = Intent(this, DataActivity::class.java)
            startActivity(cus)
        }
    }
}