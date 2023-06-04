package space.rybakov.campus.data.db

import androidx.room.*
import space.rybakov.campus.data.dao.CampusDao
import space.rybakov.campus.data.entity.AdEntity


@Database(
    entities = [
        AdEntity::class,
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDb : RoomDatabase() {
    abstract fun campusDao(): CampusDao
}