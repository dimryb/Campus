package space.rybakov.campus.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import space.rybakov.campus.databinding.FragmentSettingsBinding
import space.rybakov.campus.presentation.MainViewModel

class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding: FragmentSettingsBinding
        get() = _binding ?: throw RuntimeException("FragmentSettingsBinding == null!")

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(
            inflater,
            container,
            false
        )

        observeViewModel()
        setupClickListeners()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun observeViewModel() {

    }

    fun setupClickListeners() {
        binding.switchReview.setOnCheckedChangeListener { _, reviewEnable ->
            viewModel.reviewEnable.value = reviewEnable
        }
    }
}