package com.example.evilinsult.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.evilinsult.models.InsultoEntidad

@Database(entities = [InsultoEntidad::class], version = 2, exportSchema = false)
abstract class InsultoDB : RoomDatabase() {
    abstract fun insultoDao() : InsultoDao
}