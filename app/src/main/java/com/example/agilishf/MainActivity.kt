package com.example.agilishf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val navViewListener = object: BottomNavigationView.OnNavigationItemSelectedListener {
        override fun onNavigationItemSelected(item: MenuItem): Boolean {
            var selectedFragment:Fragment? = null
            when(item.itemId) {
                R.id.home_button -> selectedFragment = HomeFragment()
                R.id.statistics_button -> selectedFragment = StatisticsFragment()
                R.id.forklift_button -> selectedFragment = ForkliftFragment()
            }
            supportFragmentManager.beginTransaction().replace(R.id.fragment_main, selectedFragment!!).commit()
            return true
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavView:BottomNavigationView = findViewById(R.id.bottom_navigation_view)
        bottomNavView.setOnNavigationItemSelectedListener(navViewListener)
        supportActionBar?.hide()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_main, HomeFragment()).commit()

    }
}
