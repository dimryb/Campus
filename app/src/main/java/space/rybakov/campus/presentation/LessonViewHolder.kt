package space.rybakov.campus.presentation

import androidx.recyclerview.widget.RecyclerView
import space.rybakov.campus.databinding.CardSchedulerBinding
import space.rybakov.campus.entities.Lesson

class LessonViewHolder(
    private val binding: CardSchedulerBinding,
    private val onInteractionListener: OnInteractionListener,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(lesson: Lesson) {
        setContent(lesson)
        setupClickListeners(lesson)
    }

    private fun setContent(lesson: Lesson) {
        binding.apply {
            textviewLesson.text = lesson.name
        }
    }

    private fun setupClickListeners(lesson: Lesson) {
        binding.apply {
            // Пока тут кнопок нет
        }
    }

}