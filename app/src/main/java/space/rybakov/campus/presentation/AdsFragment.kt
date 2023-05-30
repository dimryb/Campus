package space.rybakov.campus.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import space.rybakov.campus.databinding.FragmentAdsBinding

class AdsFragment : Fragment() {

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
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}