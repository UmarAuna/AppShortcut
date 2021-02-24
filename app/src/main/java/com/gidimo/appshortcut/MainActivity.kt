package com.gidimo.appshortcut

import android.annotation.TargetApi
import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openURL()
        //openActivity()
    }

    @TargetApi(25)
    fun openURL() {
        val shortcutManager = getSystemService(ShortcutManager::class.java)
        val shortcut = ShortcutInfo.Builder(applicationContext, "id1")
            .setShortLabel("gidimo")
            .setLongLabel("Open gidimo website")
            .setIcon(Icon.createWithResource(applicationContext, R.drawable.ic_masks))
            .setIntent(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://www.gidimo.c om/")
                )
            )
            .build()

        shortcutManager!!.dynamicShortcuts = listOf(shortcut)
    }

   /* @TargetApi(25)
    fun openActivity() {
        val sM = getSystemService(ShortcutManager::class.java)
        val intent1 = Intent(applicationContext, MainActivity3::class.java)
        intent1.action = Intent.ACTION_VIEW

        val shortcut1 = ShortcutInfo.Builder(this, "shortcut1")
            .setIntent(intent1)
            .setShortLabel(getString(R.string.store))
            .setLongLabel("Store Dynamic")
            .setShortLabel("Store Dynamic")
            .setDisabledMessage("Store Dynamic")
            .setIcon(Icon.createWithResource(this, R.drawable.ic_store))
            .build()

        sM.dynamicShortcuts = listOf(shortcut1)
    }*/
}
