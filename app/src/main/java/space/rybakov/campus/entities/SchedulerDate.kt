package space.rybakov.campus.entities

data class ScheduleDate(
    val year: Int,
    val month: Int,
    val day: Int,
){
    override fun toString(): String {
        val stringMonth = when (month){
            1-> "января"
            2-> "февраля"
            3-> "марта"
            4-> "апреля"
            5-> "мая"
            6-> "июня"
            7-> "июля"
            8-> "августа"
            9-> "сентября"
            10-> "октября"
            11-> "ноября"
            12-> "декабря"
            else -> return ""
        }
        return "$day $stringMonth $year"
    }
}