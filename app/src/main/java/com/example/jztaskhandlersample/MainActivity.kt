package com.example.jztaskhandlersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.jztaskhandler.TaskHandler
import com.example.jztaskhandler.runner

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            TaskHandler.newInstance.runTaskTimer("s",0.01, runner{
                Log.e("runner","run")
            })
        }
    }
}
