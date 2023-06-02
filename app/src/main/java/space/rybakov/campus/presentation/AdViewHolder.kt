package space.rybakov.campus.presentation

import androidx.recyclerview.widget.RecyclerView
import space.rybakov.campus.databinding.CardAdBinding
import space.rybakov.campus.entities.Ad

class AdViewHolder(
    private val binding: CardAdBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(ad: Ad) {
        setContent(ad)
        setupClickListeners(ad)
    }

    private fun setContent(ad: Ad) {
        binding.apply {
            textviewTitle.text = ad.title
            textviewContent.text = ad.content
        }
    }

    private fun setupClickListeners(ad: Ad) {
        binding.apply {
            // Пока тут кнопок нет
        }
    }

}