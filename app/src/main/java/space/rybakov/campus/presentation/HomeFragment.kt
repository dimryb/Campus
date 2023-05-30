package space.rybakov.campus.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import space.rybakov.campus.R
import space.rybakov.campus.databinding.FragmentHomeBinding
import kotlin.math.log

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding ?: throw RuntimeException("FragmentHomeBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )
        createGroupsSpinner()
        setupListeners()
        return binding.root
    }

    private fun createGroupsSpinner() {
        val groupNames = arrayOf<String?>("ФББ-92", "ФББ-93", "ФББ-94", "ФББ-95", "ФББ-96")
        ArrayAdapter(requireContext(), R.layout.spinner_list, groupNames).also { adapter ->
            val spinner: Spinner = binding.panelTop.groupsSpinner
            spinner.adapter = adapter
        }
    }

    private fun setupListeners() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            Log.d("", item.toString())
            when (item.itemId) {
                R.id.home_button -> {
                }
                R.id.ads_button -> {
                    findNavController().navigate(R.id.adsFragment)
                }
                R.id.reviews_button -> {
                    findNavController().navigate(R.id.reviewsFragment)
                }
                R.id.settings_button -> {
                    findNavController().navigate(R.id.settingsFragment)
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}