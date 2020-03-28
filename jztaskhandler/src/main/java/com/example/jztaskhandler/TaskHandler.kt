package com.example.jztaskhandler

import android.app.Activity
import java.util.*
import kotlin.collections.ArrayList

class TaskHandler  {
companion object{
    var tool:TaskHandler? = null
    val newInstance:callback
    get(){
        if(tool==null){tool=TaskHandler()}
        return  tool!!.callback
    }

}
    var callback=object :callback{
        override fun clock(): JzClock {
            return JzClock()
        }

        override fun runTaskOnce(tag: String, callback: runner) {
            if(runtag.contains(tag)){return}else{
                runtag.add(tag)
                callback.run()
                runtag.remove(tag)
            }
        }
        override fun runTaskTimer(tag: String,time:Double, callback: runner) {

            for(i in runnerTimer){
                if(i.tag==tag){
                    if(i.timer.stop()<time){return}
                    }
            }
            val seq= (runnerTimer).filter { it.tag!=tag }
            runnerTimer= ArrayList(seq)
            val timertask= TimerTask()
            timertask.tag=tag
            timertask.timer=JzClock()
            runnerTimer.add(timertask)
            callback.run()
        }

        override fun runTaskMultiple(tag: String,count:Int, callback: runner) {
            var havecount=0
            if(runtag.contains(tag)){havecount+=1}
            if(havecount==count){return}
                runtag.add(tag)
                callback.run()
                runtag.remove(tag)
            }
        }
    var runtag=ArrayList<String>()
    var runnerTimer=ArrayList<TimerTask>()
    }


