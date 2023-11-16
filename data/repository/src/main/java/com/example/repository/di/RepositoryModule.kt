package com.example.repository.di

import com.example.domain.repositories.BookRepository
import com.example.repository.repository.BookRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @[Binds Singleton]
    fun bindsBookRepository(
        impl: BookRepositoryImpl
    ): BookRepository
}