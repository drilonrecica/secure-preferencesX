package com.reqica.drilon.android.securepreferencesxsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(this, R.id.bottomNavFragment)
        val navigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigationView.setupWithNavController(navController)
    }
}