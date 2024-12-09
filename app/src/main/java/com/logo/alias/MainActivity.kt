package com.logo.alias

import android.content.ComponentName
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<View>(R.id.buttton1).setOnClickListener {
            changeIcon(true)
        }
        findViewById<View>(R.id.buttton2).setOnClickListener {
            changeIcon(false)
        }
    }

    private fun changeIcon(default: Boolean = true) {
        // Enabling NewYearIconAlias, that represents new year icon - for example
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this,
                "$packageName.DefaultAlias"
            ),
            if (!default) PackageManager.COMPONENT_ENABLED_STATE_DISABLED
            else PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
        // Enabling NewYearIconAlias, that represents new year icon - for example
        packageManager.setComponentEnabledSetting(
            ComponentName(
                this,
                "$packageName.NextAlias"
            ),
            if (default) PackageManager.COMPONENT_ENABLED_STATE_DISABLED
            else PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
        )
    }
}