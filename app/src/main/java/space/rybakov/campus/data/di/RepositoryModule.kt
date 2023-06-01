package space.rybakov.campus.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import space.rybakov.campus.data.RepositoryImpl
import space.rybakov.campus.domain.Repository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindsRepository(impl: RepositoryImpl): Repository
}