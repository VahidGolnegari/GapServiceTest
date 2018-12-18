package com.vahidglngy.servicesample

import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val startServiceBtn by lazy {
        button_mainactivity_startservice
    }
    val stopServiceBtn by lazy {
        button_mainactivity_stopservice
    }
     val serviceIntent by lazy {
         Intent(this,MyService::class.java)
     }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startServiceBtn.setOnClickListener {
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(serviceIntent)
            } else {
                startService(serviceIntent)
            }

        }

        stopServiceBtn.setOnClickListener {
            stopService(serviceIntent)


        }
    }
}
