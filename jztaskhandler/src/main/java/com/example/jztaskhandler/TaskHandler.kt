package com.example.jztaskhandler

import androidx.lifecycle.Lifecycle
import com.example.jzlifttool.LifeTimer
import kotlin.collections.ArrayList

class TaskHandler {
    companion object {
        var tool: TaskHandler? = null
        val newInstance: callback
            get() {
                if (tool == null) {
                    tool = TaskHandler()
                }
                return tool!!.callback
            }

    }
    class stTask(var tag:String,var callback:runner)
    var storeTask=ArrayList<stTask>()
    var callback = object : callback {
        override fun runTaskTimer(
            life: Lifecycle,
            time: Long,
            delay: Long,
            callback: runner
        ): LifeTimer {
            val timer = LifeTimer(life)
            timer.schedule(delay, time, callback)
            return timer
        }

        override fun funStoreTask(tag: String, callback: runner) {
            storeTask.add(stTask(tag,callback))
        }

        override fun runTask(tag: String) {
           for(i in storeTask){
               if(i.tag==tag){
                   i.callback.run()
               }
           }
            storeTask=ArrayList(storeTask.filter { it.tag!=tag })
        }

        override fun clock(): JzClock {
            return JzClock()
        }

        override fun runTaskOnce(tag: String, callback: runner) {
            if (runtag.contains(tag)) {
                return
            } else {
                runtag.add(tag)
                callback.run()
                runtag.remove(tag)
            }
        }

        override fun runTaskDelay(tag: String, time: Double, callback: runner) {
            for (i in runnerTimer) {
                if (i.tag == tag) {
                    if (i.timer.stop() < time) {
                        return
                    }
                }
            }
            val seq = (runnerTimer).filter { it.tag != tag }
            runnerTimer = ArrayList(seq)
            val timertask = TimerTask()
            timertask.tag = tag
            timertask.timer = JzClock()
            runnerTimer.add(timertask)
            callback.run()
        }

        override fun runTaskMultiple(tag: String, count: Int, callback: runner) {
            var havecount = 0
            for (i in runtag) {
                if (i == tag) {
                    havecount += 1
                }
            }
            if (havecount == count) {
                return
            }
            runtag.add(tag)
            callback.run()
            runtag.remove(tag)
        }
    }
    var runtag = ArrayList<String>()
    var runnerTimer = ArrayList<TimerTask>()
}


