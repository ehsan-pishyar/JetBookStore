package com.example.database.di

import android.content.Context
import androidx.room.Room
import com.example.database.AppDatabase
import com.example.database.dao.BookDao
import com.example.database.utils.DatabaseConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @[Provides Singleton]
    fun providesDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context, AppDatabase::class.java, DatabaseConstants.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()

    @[Provides Singleton]
    fun providesBookDao(database: AppDatabase): BookDao = database.bookDao()
}