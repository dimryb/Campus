package space.rybakov.campus.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import space.rybakov.campus.R
import space.rybakov.campus.databinding.FragmentAds2Binding
import space.rybakov.campus.databinding.FragmentAdsBinding
import space.rybakov.campus.presentation.MainViewModel

class Ads2Fragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentAds2Binding? = null
    private val binding: FragmentAds2Binding
        get() = _binding ?: throw RuntimeException("FragmentAds2Binding == null!")


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAds2Binding.inflate(
            inflater,
            container,
            false
        )

        observeViewModel()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun observeViewModel() {

    }
}