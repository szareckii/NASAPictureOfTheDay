package com.szareckii.nasapictureoftheday.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.szareckii.nasapictureoftheday.R
import com.szareckii.nasapictureoftheday.ui.picture.fragment.PictureOfTheDayFragment
import kotlinx.android.synthetic.main.fragment_settings.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initTheme()
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PictureOfTheDayFragment.newInstance())
                    .commitNow()
        }
    }

    private fun initTheme() {
        sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return

        when(sharedPref.getInt(getString(R.string.theme), 1)) {
            1 -> setTheme(R.style.AppTheme)
            2 -> setTheme(R.style.AppThemeSpace)
        }
    }
}