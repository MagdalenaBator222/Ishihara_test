package com.pl.agh.bator.ishihara_test

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.pl.agh.bator.ishihara_test.databinding.ActivityMainBinding

@SuppressLint("StaticFieldLeak")
private lateinit var navController: NavController

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // set up the navigation controller:
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }
}