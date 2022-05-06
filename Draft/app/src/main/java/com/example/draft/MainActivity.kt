package com.example.draft

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var text:String = "a <bbb> c d -eee="
    private var tvText: TextView? = null
    private var tvView: TextView? = null





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvText = findViewById(R.id.tvText)
        tvView = findViewById(R.id.textView)
        var subText: String = text.substringAfter('<')
        var subText2: String = subText.substringBefore('>')
        var subText3: String = text.substringAfter('-')
        var subText4: String = subText3.substringBefore('=')

        tvText?.setText(subText2)
        tvView?.setText(subText4)
    }
}