package com.example.changeiconapp

import android.content.ComponentName
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.changeIcon)
        button.setOnClickListener {
            val manager = packageManager
            val value = manager.getComponentEnabledSetting(ComponentName(
                applicationContext,
                MainActivity::class.java
            ))
            if(value == PackageManager.COMPONENT_ENABLED_STATE_ENABLED) {
                manager.setComponentEnabledSetting(
                    ComponentName(
                        applicationContext,
                        MainActivity::class.java
                    ),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP
                )
                manager.setComponentEnabledSetting(
                    ComponentName(
                        applicationContext,
                        MainActivityAlias::class.java
                    ),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP

                )
            } else {

                manager.setComponentEnabledSetting(
                    ComponentName(
                        applicationContext,
                        MainActivity::class.java
                    ),
                    PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                    PackageManager.DONT_KILL_APP
                )
                manager.setComponentEnabledSetting(
                    ComponentName(
                        applicationContext,
                        MainActivityAlias::class.java
                    ),
                    PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                    PackageManager.DONT_KILL_APP

                )
            }
        }
    }
}