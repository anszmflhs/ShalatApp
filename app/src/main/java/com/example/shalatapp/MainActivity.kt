package com.example.shalatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.shalatapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manageFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment? ?: return

        val navControler = manageFragment.navController

        binding.bottomNavigationView.setupWithNavController(navControler)
    }
}