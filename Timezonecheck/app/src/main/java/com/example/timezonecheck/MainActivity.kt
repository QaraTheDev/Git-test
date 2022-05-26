package com.example.timezonecheck

import android.icu.util.TimeZone
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timezoneArray = TimeZone.getAvailableIDs()
        val timezone = TimeZone.getDefault().id

        val tz = SimpleTimeZone.getDefault()
        println(tz)
    }
}