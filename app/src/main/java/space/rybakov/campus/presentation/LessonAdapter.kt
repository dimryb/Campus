package space.rybakov.campus.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import space.rybakov.campus.databinding.CardAdBinding
import space.rybakov.campus.databinding.CardSchedulerBinding
import space.rybakov.campus.entities.Ad
import space.rybakov.campus.entities.Lesson

class LessonAdapter(
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<Lesson, LessonViewHolder>(LessonDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val binding = CardSchedulerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}