package space.rybakov.campus.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import space.rybakov.campus.databinding.CardTeacherBinding
import space.rybakov.campus.entities.Teacher

class TeachersAdapter(
    private val onInteractionListener: OnInteractionListener,
) : ListAdapter<Teacher, TeacherViewHolder>(TeacherDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeacherViewHolder {
        val binding =
            CardTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeacherViewHolder(binding, onInteractionListener)
    }

    override fun onBindViewHolder(holder: TeacherViewHolder, position: Int) {
        val review = getItem(position)
        holder.bind(review)
    }
}