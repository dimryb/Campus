package space.rybakov.campus.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import space.rybakov.campus.databinding.FragmentReviewsBinding
import space.rybakov.campus.entities.Ad
import space.rybakov.campus.presentation.MainViewModel
import space.rybakov.campus.presentation.OnInteractionListener
import space.rybakov.campus.presentation.ReviewsAdapter

class ReviewsFragment : Fragment() {

    private val viewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentReviewsBinding? = null
    private val binding: FragmentReviewsBinding
        get() = _binding ?: throw RuntimeException("FragmentReviewsBinding == null!")

    private val reviewsAdapter = ReviewsAdapter(object : OnInteractionListener {
        override fun onClick(ad: Ad) {
            TODO("Not yet implemented")
        }
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReviewsBinding.inflate(
            inflater,
            container,
            false
        )

        binding.reviewsList.adapter = reviewsAdapter

        observeViewModel()
        viewModel.getLastReview()

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun observeViewModel() {
        viewModel.reviews.observe(viewLifecycleOwner) { reviews ->
            reviewsAdapter.submitList(reviews)
        }
    }
}