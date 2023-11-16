package com.example.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.database.dao.BookDao
import com.example.database.models.BookResponseEntity
import com.example.database.utils.DatabaseConstants

@Database(
    entities = [
        BookResponseEntity::class
    ],
    version = DatabaseConstants.DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun bookDao(): BookDao
}
