package space.rybakov.campus.data.db

import androidx.room.*
import space.rybakov.campus.data.dao.CampusDao
import space.rybakov.campus.data.entity.AdEntity
import space.rybakov.campus.data.entity.LessonEntity
import space.rybakov.campus.data.entity.ReviewEntity
import space.rybakov.campus.data.entity.TeacherEntity


@Database(
    entities = [
        AdEntity::class,
        ReviewEntity::class,
        TeacherEntity::class,
        LessonEntity::class,
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDb : RoomDatabase() {
    abstract fun campusDao(): CampusDao
}