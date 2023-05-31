package space.rybakov.campus.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import space.rybakov.campus.R
import space.rybakov.campus.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity(R.layout.activity_app) {

    private lateinit var binding: ActivityAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()

        setupListeners()
    }

    private fun setupListeners() {
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_activity) as NavHostFragment? ?: return
        val navController = host.navController

        //val bottomNav = binding.bottomNavigation //TODO: разобраться почему не работает через binding
        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNav.setOnItemSelectedListener { item ->
            Log.d("", item.toString())
            when (item.itemId) {
                R.id.schedule_button -> {
                    navController.navigate(R.id.homeFragment)
                    //navController.navigateUp()
                }
                R.id.ads_button -> {
                    navController.navigate(R.id.adsFragment)
                }
                R.id.reviews_button -> {
                    navController.navigate(R.id.reviewsFragment)
                }
                R.id.settings_button -> {
                    navController.navigate(R.id.settingsFragment)
                }
            }
            true
        }
    }
}