package space.rybakov.campus.presentation

import androidx.recyclerview.widget.DiffUtil
import space.rybakov.campus.entities.Ad

class AdDiffCallback : DiffUtil.ItemCallback<Ad>() {
    override fun areItemsTheSame(oldItem: Ad, newItem: Ad): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Ad, newItem: Ad): Boolean {
        return oldItem == newItem
    }
}