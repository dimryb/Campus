package space.rybakov.campus.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import space.rybakov.campus.data.dao.CampusDao
import space.rybakov.campus.data.entity.*
import space.rybakov.campus.domain.Repository
import space.rybakov.campus.entities.*
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val campusDao: CampusDao,
) : Repository {
    override val ads = campusDao.getAds().map(List<AdEntity>::toDto).flowOn(Dispatchers.Default)
    override val reviews =
        campusDao.getReviews().map(List<ReviewEntity>::toDto).flowOn(Dispatchers.Default)
    override val teachers =
        campusDao.getTeacher().map(List<TeacherEntity>::toDto).flowOn(Dispatchers.Default)

    override suspend fun getAds() {
        val adsList = mutableListOf(
            // Это все для красивых тестов
            Ad(
                1,
                title = "В библиотеке — выставка рисунков",
                content = """
Научная библиотека НГТУ НЭТИ приглашает посетить выставку рисунков «Донбасс. Дети и война». 
Здесь представлены работы детей Донбасса, нарисованные в 2014—2015 годах.
                """
            ),
            Ad(
                2,
                title = "В НГТУ НЭТИ показали беспилотные системы",
                content = """
Форум-выставка «Первый беспилотный» прошел 14 декабря в Точке кипения НГТУ НЭТИ.
Мероприятие подготовлено совместно с ГАУ НСО «Новосибирский областной инновационный фонд» при поддержке АНО «Платформа НТИ».
На выставке были показаны образцы беспилотных авиационных систем. БПЛА собственных разработок представили: 
ООО «Оптиплейн Аэродинамика», КБ «Спектр», НГТУ НЭТИ, НГАУ, Лицей №22 «Сила Сибири», 
Аэрокосмический лицей имени Ю.В. Кондратюка, Детский технопарк «Кванториум Новосибирск».
                """
            ),
            Ad(
                3,
                title = "ДОД целевого обучения",
                content = """
НГТУ НЭТИ стал организатором уникального мероприятия — Выставки-2023 
«Целевое обучение в вузах для промышленности». 
Руководители предприятий и вузов в формате презентационных столов ознакомили абитуриентов со своей деятельностью, 
провели консультации и обменялись контактами.
                """
            ),
            Ad(
                4,
                title = "Лига абитуриентов НГТУ НЭТИ»: греко-римская борьба",
                content = """
В эти выходные прошли соревнования по греко-римской борьбе в рамках «Лиги абитуриентов». 
Более 40 спортсменов из Новосибирска, НСО и Сибирского федерального округа боролись за звание 
чемпионов и дополнительные баллы к ЕГЭ. Поздравляем победителей и призеров!
                """
            ),
        )
        campusDao.insertAds(adsList.toEntity())
    }

    override suspend fun getLastReview() {
        val reviewsList = mutableListOf(
            Review(
                id = 1,
                teacher = "Зайцева Татьяна Ивановна",
                content = "Нормальные оценки ставить",
                credit = 4.2f,
            ),
            Review(
                id = 2,
                teacher = "Федорова Елена Ольговна",
                content = "Какая-то не очень, но мне нравится",
                credit = 7.2f,
            ),
        )
        campusDao.insertReviews(reviewsList.toEntity())
    }

    override suspend fun getTeachers() {
        val teachersList = mutableListOf(
            Teacher(
                name = "Преподаватель 1",
                rating = 1.1f,
            ),
            Teacher(
                name = "Преподаватель 2",
                rating = 2.2f,
            ),
            Teacher(
                name = "Преподаватель 3",
                rating = 3.3f,
            ),
            Teacher(
                name = "Преподаватель 4",
                rating = 4.4f,
            ),
            Teacher(
                name = "Преподаватель 5",
                rating = 5.5f,
            ),
            Teacher(
                name = "Преподаватель 6",
                rating = 6.6f,
            ),
            Teacher(
                name = "Преподаватель 7",
                rating = 7.7f,
            ),
        )
        campusDao.insertTeacher(teachersList.toEntity())
    }

    override suspend fun fillSchedule() {
        val lessonList = mutableListOf(
            Lesson(
                id = 1,
                name = "Первая группа понедельник",
                groupId = 0,
                dayInd = 1
            ),
            Lesson(
                id = 2,
                name = "Вторая группа вторник",
                groupId = 1,
                dayInd = 2
            ),
            Lesson(
                id = 3,
                name = "Вторая группа среда",
                groupId = 1,
                dayInd = 3
            ),
            Lesson(
                id = 4,
                name = "Вторая группа четверг",
                groupId = 1,
                dayInd = 4
            ),
            Lesson(
                id = 5,
                name = "Вторая группа пятница",
                groupId = 1,
                dayInd = 5
            ),
        )
        campusDao.insertSchedule(lessonList.toEntity())
    }

    override fun getSchedule(group: Group, date: ScheduleDate): List<Lesson> {
        return try {
            val groupId = group.id
            val dayInd = date.getWeekDayInt()
            campusDao.getSchedule(groupId = groupId, dayInd = dayInd).toDto()
        }catch (e: Exception){
            Log.e("error", e.toString())
            emptyList<Lesson>()
        }
    }

}
