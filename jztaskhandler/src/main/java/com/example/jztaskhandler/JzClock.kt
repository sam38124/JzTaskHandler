package com.example.jztaskhandler

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

 class JzClock{
    val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS")
    var past = sdf.parse(sdf.format(Date()))

    fun Zeroing(){
        past = sdf.parse(sdf.format(Date()))
    }
    fun stop():Double{
        val now = sdf.parse(sdf.format(Date()))

        return getDatePoor(now,past)
    }
    fun getDatePoor(endDate: Date, nowDate: Date): Double {
        val diff = endDate.time - nowDate.time
        val sec = diff.toDouble() / 1000
        Log.e("stop",""+sec)
        return sec.toDouble()
    }
}