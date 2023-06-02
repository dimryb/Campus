package space.rybakov.campus.presentation

import androidx.recyclerview.widget.RecyclerView
import space.rybakov.campus.databinding.CardLastReviewBinding
import space.rybakov.campus.entities.Review


class ReviewViewHolder(
    private val binding: CardLastReviewBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(review: Review) {
        setContent(review)
        setupClickListeners(review)
    }

    private fun setContent(review: Review) {
        binding.apply {
            textviewTeacher.text = review.teacher
            textviewContent.text = review.content
            textviewCredit.text = review.credit.toString()
        }
    }

    private fun setupClickListeners(review: Review) {
        binding.apply {
            // Пока тут кнопок нет
        }
    }

}