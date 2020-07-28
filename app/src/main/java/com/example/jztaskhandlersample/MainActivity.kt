package com.example.jztaskhandlersample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.example.jzlifttool.LifeTimer
import com.example.jztaskhandler.TaskHandler
import com.example.jztaskhandler.runner
import com.example.jztaskhandler.timer.callback

class MainActivity : AppCompatActivity() {
    lateinit var timer: LifeTimer
    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button).setOnClickListener {
            TaskHandler.newInstance.runTaskDelay("s",0.01, runner{
                Log.e("runner","run")
            })
            TaskHandler.newInstance.runTaskMultiple("s",5, runner{
                Log.e("runner","run")
            })
            TaskHandler.newInstance.runTaskOnce("s", runner{
                Log.e("runner","run")
            })
            TaskHandler.newInstance.runTaskTimer(lifecycle,1000,5000, runner {
                i += 1
                Log.e("state", "$i")
            })
            val clock=TaskHandler.newInstance.clock()
            clock.Zeroing()
            clock.stop()
        }
        timer = LifeTimer(lifecycle)
        timer.schedule(0, 1000 * 1, runner {
            i += 1
            Log.e("state", "$i")
        })
    }
}
