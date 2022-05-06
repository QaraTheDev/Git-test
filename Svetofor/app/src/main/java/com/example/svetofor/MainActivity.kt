package com.example.svetofor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameList = ArrayList<String>()
        nameList.add("ChikiBriki")
        nameList.add("Vdamki")

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,nameList)
        listView.adapter = adapter
    }
}