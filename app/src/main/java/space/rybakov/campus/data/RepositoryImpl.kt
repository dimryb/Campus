package space.rybakov.campus.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import space.rybakov.campus.domain.Repository
import space.rybakov.campus.entities.Ad
import space.rybakov.campus.entities.Review
import space.rybakov.campus.entities.Teacher
import javax.inject.Inject

class RepositoryImpl @Inject constructor() : Repository {
    private val _ads = MutableSharedFlow<List<Ad>>(replay = 1)
    override val ads: Flow<List<Ad>>
        get() = _ads

    private val _reviews = MutableSharedFlow<List<Review>>(replay = 1)
    override val reviews: Flow<List<Review>>
        get() = _reviews

    private val _teachers = MutableSharedFlow<List<Teacher>>(replay = 1)
    override val teachers: Flow<List<Teacher>>
        get() = _teachers

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
                1,
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
                1,
                title = "ДОД целевого обучения",
                content = """
НГТУ НЭТИ стал организатором уникального мероприятия — Выставки-2023 
«Целевое обучение в вузах для промышленности». 
Руководители предприятий и вузов в формате презентационных столов ознакомили абитуриентов со своей деятельностью, 
провели консультации и обменялись контактами.
                """
            ),
            Ad(
                1,
                title = "Лига абитуриентов НГТУ НЭТИ»: греко-римская борьба",
                content = """
В эти выходные прошли соревнования по греко-римской борьбе в рамках «Лиги абитуриентов». 
Более 40 спортсменов из Новосибирска, НСО и Сибирского федерального округа боролись за звание 
чемпионов и дополнительные баллы к ЕГЭ. Поздравляем победителей и призеров!
                """
            ),
        )
        _ads.tryEmit(adsList)
    }

    override suspend fun getLastReview() {
        val reviewsList = mutableListOf(
            Review(
                teacher = "Зайцева Татьяна Ивановна",
                content = "Нормальные оценки ставить",
                credit = 4.2f,
            ),
            Review(
                teacher = "Федорова Елена Ольговна",
                content = "Какая-то не очень, но мне нравится",
                credit = 7.2f,
            ),
        )
        _reviews.tryEmit(reviewsList)
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
        _teachers.tryEmit(teachersList)
    }
}