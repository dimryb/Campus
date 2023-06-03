package space.rybakov.campus.presentation

import androidx.recyclerview.widget.RecyclerView
import space.rybakov.campus.databinding.CardTeacherBinding
import space.rybakov.campus.entities.Teacher

class TeacherViewHolder(
    private val binding: CardTeacherBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(teacher: Teacher) {
        setContent(teacher)
        setupClickListeners(teacher)
    }

    private fun setContent(teacher: Teacher) {
        binding.apply {
            textviewTeacher.text = teacher.name
            textviewCredit.text = teacher.rating.toString()
        }
    }

    private fun setupClickListeners(teacher: Teacher) {
        binding.apply {
            // Пока тут кнопок нет
        }
    }

}