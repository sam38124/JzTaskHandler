# JzTaskHandler
[![](https://jitpack.io/v/sam38124/JzFrameWork.svg)](https://jitpack.io/#sam38124/JzFrameWork)
[![Platform](https://img.shields.io/badge/平台-%20Android%20-brightgreen.svg)](https://github.com/sam38124)
[![characteristic](https://img.shields.io/badge/特點-%20輕量級%20%7C%20簡單易用%20%20%7C%20穩定%20-brightgreen.svg)](https://github.com/sam38124)
# JzTaskHandler
這是一套非常簡單使用的Android任務處理框架~~<br>
覺得好用就順手STAR吧!!
## 目錄
* [如何導入到專案](#Import)
* [任務處理](#Use)
* [碼表使用](#tasker)
* [所有對外暴露方法](#All)
* [關於我](#About)

<a name="Import"></a>
## 如何導入到項目
> 支持jcenter。 <br/>

### jcenter導入方式
在app專案包的build.gradle中添加
```kotlin
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

在需要用到這個庫的module中的build.gradle中的dependencies中加入
```kotlin
dependencies {
implementation 'com.github.sam38124: JzTaskHandler:v8.4'
```
<a name="Use"></a>
## 任務處理

### 1.單任務處理
#### 同時間只能執行一項任務，任務未完成則不可執行新任務
```kotlin
     TaskHandler.newInstance.runTaskOnce("TAG", runner{
                Log.e("runner","run")
            })
```
### 2.多任務處理
#### 同時間能執行多個任務，但不能超過自定義執行上限
```kotlin
//這裡的範例為，最多能同時執行5個任務
TaskHandler.newInstance.runTaskMultiple("TAG",5, runner{
                Log.e("runner","run")
            })
```
### 3.時間任務處理
#### 每個任務間隔必須大於自定義秒數才能開啟新任務
```kotlin
//這裡的範例為，至少需2.5秒才可以開始執行新任務
       TaskHandler.newInstance.runTaskTimer("s",2.5, runner{
                Log.e("runner","run")
            })
```
## 時間計時器

### 1.建立宣告
```kotlin
val clock=TaskHandler.newInstance.clock()
```
### 2.開始計時前必須把碼表歸零
```kotlin
 clock.Zeroing()
```
### 3.碼表暫停並且返回秒數
```kotlin
clock.stop()
```
### 4.範例
```kotlin
//先睡個2.5秒
Thread.sleep(2500)
//碼表暫停
var time=clock.stop()
//time會返回2.5的近似值
```
<a name="All"></a>
### 所有對外暴露的方法
```kotlin

interface callback{
    //取得碼表
    fun clock(): JzClock
    //執行任務處理，並且同時間只能處理一次任務，必須等任務處理完才能進行下次的執行
    fun runTaskOnce(tag:String,callback: runner)
    //執行任務處理，並且必須大於時間間隔才可以再次執行
    fun runTaskTimer(tag:String,time:Double, callback: runner)
    //執行任務處理，並且限制可同時執行數量
    fun runTaskMultiple(tag:String,count:Int,callback: runner)
}
```

<a name="About"></a>
### 關於我
橙的電子android and ios developer

*line:sam38124

*gmail:sam38124@gmail.com
