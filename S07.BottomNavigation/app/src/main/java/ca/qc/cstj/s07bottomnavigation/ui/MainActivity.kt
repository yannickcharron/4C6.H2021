package ca.qc.cstj.s07bottomnavigation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import ca.qc.cstj.s07bottomnavigation.R
import ca.qc.cstj.s07bottomnavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Trouver notre gestionnaire de fragment et notre NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        //Trouver notre controlleur de navigation
        val navController = navHostFragment.navController

        //Définir la navigation
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.searchFragment, R.id.favoritesFragment, R.id.settingsFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bnvNavigation.setupWithNavController(navController)
    }
}