package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.repo.GorevlerDaoRepository
import com.example.todoapp.room.GorevlerDao
import com.example.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {


@Provides
@Singleton
fun provideGorevlerDaoRepository(gdao: GorevlerDao) : GorevlerDaoRepository {
    return GorevlerDaoRepository(gdao)
}
    @Provides
    @Singleton
    fun provideGorevlerDao(@ApplicationContext context : Context) : GorevlerDao {
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"gorevler.sqlite")
            .createFromAsset("gorevler.sqlite").build()

        return vt.getGorevlerDao()
    }
}
