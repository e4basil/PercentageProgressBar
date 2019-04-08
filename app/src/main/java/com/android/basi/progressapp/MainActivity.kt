package com.android.basi.progressapp

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {
    val updateHandler = Handler()
    var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val runnable = object : Runnable {
            override fun run() {
//
            updateProgress(i)
                updateHandler.postDelayed(this, 1000)
                i++
            }
        }
        updateHandler.post(runnable)
    }

    private fun updateProgress(i: Int) {

            ppb.progress = i * 10
            Logger.getLogger(this::class.java.simpleName).warning("I is $i")
    }
}
