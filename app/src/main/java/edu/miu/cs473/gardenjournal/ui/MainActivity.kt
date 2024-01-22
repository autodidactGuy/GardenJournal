package edu.miu.cs473.gardenjournal.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import edu.miu.cs473.gardenjournal.R
import edu.miu.cs473.gardenjournal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = Navigation.findNavController(this, R.id.fragment_container)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(Navigation.findNavController(this, R.id.fragment_container),null)
    }
}