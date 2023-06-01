package space.rybakov.campus.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import space.rybakov.campus.databinding.FragmentAdsBinding

class AdsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentAdsBinding? = null
    private val binding: FragmentAdsBinding
        get() = _binding ?: throw RuntimeException("FragmentAdsBinding == null!")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdsBinding.inflate(
            inflater,
            container,
            false
        )


        observeViewModel()
        viewModel.getAds()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun observeViewModel() {
        viewModel.ads.observe(viewLifecycleOwner) {
            Log.d("ads", "ads data: $it")
        }
    }
}