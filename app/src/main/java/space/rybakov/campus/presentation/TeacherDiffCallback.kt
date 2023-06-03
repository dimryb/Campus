package space.rybakov.campus.presentation

import androidx.recyclerview.widget.DiffUtil
import space.rybakov.campus.entities.Teacher

class TeacherDiffCallback : DiffUtil.ItemCallback<Teacher>() {
    override fun areItemsTheSame(oldItem: Teacher, newItem: Teacher): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Teacher, newItem: Teacher): Boolean {
        return oldItem == newItem
    }
}