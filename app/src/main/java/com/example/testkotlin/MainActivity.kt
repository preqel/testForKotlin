package com.example.testkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    var str: String = "df"

    var datas :List<Int>?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        str.first()
        str.last()
        datas = listOf(1,3,5,23)

        var result = datas!!.all {
            it%2==1
        }
        var result2 = datas!!.map {   it<15  }
        //result.toString()

        tv.setText(  result2.joinToString (prefix = "{",postfix = "}"))
        tv.setOnClickListener {
            System.out.println("ddf")
        }
        Xiecheng()
    }


    fun Xiecheng() {
        GlobalScope.launch { // launch a new coroutine in background and continue
            delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
            //println("World!") // print after delay
            Log.d("TAG","World!")
        }
        Log.d("TAG","Hello,")
        //println("Hello,") // main thread continues while coroutine is delayed
        Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
    }
}
