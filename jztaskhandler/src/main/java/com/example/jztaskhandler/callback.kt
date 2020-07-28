package com.example.jztaskhandler

import android.app.Activity
import androidx.lifecycle.Lifecycle
import com.example.jzlifttool.LifeTimer


interface callback{
    //取得碼表
    fun clock(): JzClock
    //執行任務處理，並且同時間只能處理一次任務，必須等任務處理完才能進行下次的執行
    fun runTaskOnce(tag:String,callback: runner)
    //執行任務處理，並且必須大於時間間隔才可以再次執行
    fun runTaskDelay(tag:String,time:Double, callback: runner)
    //執行任務處理，並且限制可同時執行數量
    fun runTaskMultiple(tag:String,count:Int,callback: runner)
    //執行timer，此timer會根據fragment的生命週期銷毀或繼續執行
    fun runTaskTimer(life: Lifecycle,time:Long,delay:Long,callback:runner): LifeTimer
}