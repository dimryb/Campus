package space.rybakov.campus.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.yandex.mobile.ads.banner.AdSize
import com.yandex.mobile.ads.banner.BannerAdEventListener
import com.yandex.mobile.ads.banner.BannerAdView
import com.yandex.mobile.ads.common.AdRequest
import com.yandex.mobile.ads.common.AdRequestError
import com.yandex.mobile.ads.common.ImpressionData
import space.rybakov.campus.R
import space.rybakov.campus.databinding.FragmentAds2Binding
import space.rybakov.campus.presentation.MainViewModel
import space.rybakov.campus.presentation.ScreenUtil.screenHeight
import space.rybakov.campus.presentation.ScreenUtil.screenWidth


class Ads2Fragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentAds2Binding? = null
    private val binding: FragmentAds2Binding
        get() = _binding ?: throw RuntimeException("FragmentAds2Binding == null!")

    private var bannerWidth = 0
    private var bannerHeight = 0
    private var bannerAd: BannerAdView? = null

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
        initBanner()
        createBanner()

        return binding.root
    }

    private fun initBanner() {
        bannerAd = binding.banner
        bannerWidth = requireActivity().screenWidth
        bannerHeight = requireActivity().screenHeight / 2
    }

    private fun destroyBanner() {
        bannerAd?.let {
            it.destroy()
            binding.root.removeView(it)
        }
        bannerAd = null
    }

    private fun createBanner() {
        bannerAd = BannerAdView(requireContext()).apply {
            id = R.id.banner
            setAdUnitId("R-M-2436145-1")
            setAdSize(AdSize.flexibleSize(bannerWidth, bannerHeight))
        }
        val params = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.MATCH_PARENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
        ).apply {
            bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
            topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        }
        binding.root.addView(bannerAd, params)
        val adRequest = AdRequest.Builder().build()
        bannerAd?.loadAd(adRequest)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun observeViewModel() {

    }
}