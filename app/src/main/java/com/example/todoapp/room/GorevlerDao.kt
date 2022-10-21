package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Query
import com.example.todoapp.data.entity.Gorevler

@Dao
interface GorevlerDao{
    @Query("SELECT * FROM gorevler")
    suspend fun tumGorevler() : List<Gorevler>


}