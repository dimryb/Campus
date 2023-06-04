package space.rybakov.campus.data.dao

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.rybakov.campus.data.db.AppDb

@InstallIn(SingletonComponent::class)
@Module
object DaoModule {
    @Provides
    fun providePostDao(appDb: AppDb): CampusDao = appDb.campusDao()
}