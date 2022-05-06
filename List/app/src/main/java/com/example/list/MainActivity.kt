package com.example.list

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import com.example.list.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d
        )

        val name = arrayOf(
            "Aisulu",
            "Esken",
            "Johny",
            "Andas"
        )

        val lastMessage = arrayOf(
            "Yooo",
            "Kak Dela?",
            "How is going?",
            "*** goes Brrr"
        )

        val lastMsgTime = arrayOf(
            "7:00 pm",
            "8:00 pm",
            "9:00 pm",
            "9:00 pm"
        )

        val phoneNum = arrayOf(
            "1234",
            "1235",
            "1236",
            "1237"
        )

        val country = arrayOf(
            "Turkey",
            "Germany",
            "USA",
            "South Korea"
        )

        userArrayList = ArrayList()

        for (i in name.indices){
            val user =User(name[i], lastMessage[i], lastMsgTime[i], phoneNum[i], country[i], imageId[i])
            userArrayList.add(user)

        }

        var adapter =  MyAdapter(this, userArrayList)

        binding.listview.isClickable = true
        binding.listview.adapter = adapter
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val name = name[position]
            val phone = phoneNum[position]
            val country = country[position]
            val imageId = imageId[position]

            val i = Intent(this, UserActivity::class.java)
            i.putExtra("name",name)
            i.putExtra("phone", phone)
            i.putExtra("country",country)
            i.putExtra("imageId", imageId)
            startActivity(i)
        }
    }
}