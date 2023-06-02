package space.rybakov.campus.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import space.rybakov.campus.databinding.FragmentAdsBinding
import space.rybakov.campus.entities.Ad
import space.rybakov.campus.presentation.AdsAdapter
import space.rybakov.campus.presentation.MainViewModel
import space.rybakov.campus.presentation.OnInteractionListener

class AdsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentAdsBinding? = null
    private val binding: FragmentAdsBinding
        get() = _binding ?: throw RuntimeException("FragmentAdsBinding == null!")

    private val adsAdapter = AdsAdapter(object : OnInteractionListener {
        override fun onClick(ad: Ad) {
            TODO("Not yet implemented")
        }
    })

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

        binding.adsList.adapter = adsAdapter

        observeViewModel()
        viewModel.getAds()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun observeViewModel() {
        viewModel.ads.observe(viewLifecycleOwner) { ads ->
            adsAdapter.submitList(ads)
        }
    }
}