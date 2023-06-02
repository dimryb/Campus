package space.rybakov.campus.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import space.rybakov.campus.databinding.CardAdBinding
import space.rybakov.campus.entities.Ad

class AdsAdapter(
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<Ad, AdViewHolder>(AdDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdViewHolder {
        val binding = CardAdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: AdViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}