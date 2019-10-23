package net.kathir.myapplication

import android.content.Intent
import android.content.pm.ShortcutInfo
import android.content.pm.ShortcutManager
import android.graphics.drawable.Icon
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N_MR1)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Dynamic View to create the shortcut
        val intent1 = Intent(applicationContext, MainActivity::class.java)
        intent1.action = Intent.ACTION_VIEW

        val intent2 = Intent(applicationContext,ProfileActivity::class.java)
        intent2.action = Intent.ACTION_VIEW

        val intent3 = Intent(applicationContext,SettingsActivity::class.java)
        intent3.action = Intent.ACTION_VIEW

        val intent4 = Intent(applicationContext,MapActivity::class.java)
        intent4.action = Intent.ACTION_VIEW

        val shortcutManager = getSystemService<ShortcutManager>(ShortcutManager::class.java)

        val shortcut = ShortcutInfo.Builder(this@MainActivity, "id1")
            .setShortLabel("Home")
            .setIcon(Icon.createWithResource(this@MainActivity, R.drawable.home))
            .setIntent(intent1)
            .build()


        val shortcut1 = ShortcutInfo.Builder(this@MainActivity, "id2")
            .setShortLabel("Profile")
            .setIcon(Icon.createWithResource(this@MainActivity, R.drawable.profile))
            .setIntent(intent2)
            .build()

        val shortcut2 = ShortcutInfo.Builder(this@MainActivity, "id3")
            .setShortLabel("Settings")
            .setIcon(Icon.createWithResource(this@MainActivity, R.drawable.settings))
            .setIntent(intent3)
            .build()

        val shortcut3 = ShortcutInfo.Builder(this@MainActivity, "id4")
            .setShortLabel("Map")
            .setIcon(Icon.createWithResource(this@MainActivity, R.drawable.map))
            .setIntent(intent4)
            .build()



        shortcutManager!!.dynamicShortcuts = Arrays.asList(shortcut,shortcut1,shortcut2,shortcut3)



        textViewVal.setText("This is HomeActivity")
    }


}
