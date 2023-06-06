package space.rybakov.campus.entities

import java.time.DayOfWeek
import java.time.LocalDate

data class ScheduleDate(
    val year: Int,
    val month: Int,
    val day: Int,
) {
    fun getWeekDay(): DayOfWeek {
        val date = LocalDate.of(year, month, day)
        return date.dayOfWeek
    }

    fun getWeekDayInt() = getWeekDay().value

    override fun toString(): String {
        val stringMonth = when (month) {
            1 -> "января"
            2 -> "февраля"
            3 -> "марта"
            4 -> "апреля"
            5 -> "мая"
            6 -> "июня"
            7 -> "июля"
            8 -> "августа"
            9 -> "сентября"
            10 -> "октября"
            11 -> "ноября"
            12 -> "декабря"
            else -> return ""
        }
        val weekDay = getWeekDay()
        val stringWeekDay = when (weekDay.value) {
            1 -> "ПН"
            2 -> "ВТ"
            3 -> "СР"
            4 -> "ЧТ"
            5 -> "ПТ"
            6 -> "СБ"
            7 -> "ВС"
            else -> return ""
        }
        return "$stringWeekDay $day $stringMonth $year"
    }

    companion object {
        fun now(): ScheduleDate{
            val date = LocalDate.now()
            return ScheduleDate(date.year, date.monthValue, date.dayOfMonth)
        }
    }
}