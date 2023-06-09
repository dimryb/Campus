package space.rybakov.campus.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint
import space.rybakov.campus.R
import space.rybakov.campus.databinding.ActivityAppBinding

@AndroidEntryPoint
class AppActivity : AppCompatActivity(R.layout.activity_app) {

    private lateinit var binding: ActivityAppBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBinding.inflate(layoutInflater)
    }

    override fun onStart() {
        super.onStart()

        setupListeners()
        observeViewModel()
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

    private fun observeViewModel() {
        val reviewButton = findViewById<BottomNavigationItemView>(R.id.reviews_button)
        mainViewModel.reviewEnable.observe(this){
            reviewButton.visibility = if (it) View.VISIBLE else View.GONE
        }
    }
}