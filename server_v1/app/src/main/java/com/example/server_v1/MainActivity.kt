package com.example.server_v1

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ktx.Firebase
import com.google.firebase.ktx.initialize
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.ktx.storage
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var storage: FirebaseStorage

    lateinit var remoteConfig: FirebaseRemoteConfig

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        storage = Firebase.storage
        Firebase.initialize(this)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        remoteConfig = Firebase.remoteConfig
        val configSettings = remoteConfigSettings {
            minimumFetchIntervalInSeconds = 3600
        }
        remoteConfig.setConfigSettingsAsync(configSettings)


/*
        includesForCreateReference()
*/

        remoteConfig.fetchAndActivate()

        val checkLink = remoteConfig.getString("check_link")
        val uuid: String = UUID.randomUUID().toString()
        Log.d(null, checkLink)

        val timezoneArray = TimeZone.getAvailableIDs()
        val timezone = TimeZone.getDefault().id

        println(timezone)
/*
        val tz = TimeZone.getDefault()
*/

        /*val TimeZoneTextview = "Time Zone : " + tz
        findViewById<TextView>(R.id.timezone).text = TimeZoneTextview*/


/*        println(
            checkLink + "/?" + "packageid=com.example.server_v1" + "&" + "usserid=" + uuid + "&" + "getz=" + tz.id + tz.getDisplayName(
                false,
                TimeZone.SHORT) + "&" + "getr=utm_source=google-play&utm_medium=organic"
        )*/
    }


















    /*private fun includesForCreateReference() {
        val storage = Firebase.storage

        // ## Create a Reference

        // [START create_storage_reference]
        // Create a storage reference from our app
        var storageRef = storage.reference

        // [START download_via_url]
        storageRef.child("users/me/profile.png").downloadUrl.addOnSuccessListener {
                // Got the download URL for 'users/me/profile.png'

        }.addOnFailureListener {
            // Handle any errors
        }
        // [END download_via_url]
    }*/
}