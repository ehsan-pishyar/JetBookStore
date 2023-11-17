package com.example.use_cases

import com.example.domain.repositories.BookRepository
import com.example.domain.use_cases.AddBookUseCase
import com.example.domain.use_cases.DeleteBookUseCase
import com.example.domain.use_cases.GetBookUseCase
import com.example.domain.use_cases.GetBooksUseCase
import com.example.domain.use_cases.UpdateBookUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object BookUseCaseModule {

    @Provides
    fun providesAddBookUseCase(
        repository: BookRepository
    ): AddBookUseCase = AddBookUseCase(repository = repository)

    @Provides
    fun providesUpdateBookUseCase(
        repository: BookRepository
    ): UpdateBookUseCase = UpdateBookUseCase(repository = repository)

    @Provides
    fun providesGetBooksUseCase(
        repository: BookRepository
    ): GetBooksUseCase = GetBooksUseCase(repository = repository)

    @Provides
    fun providesGetBookUseCase(
        repository: BookRepository
    ): GetBookUseCase = GetBookUseCase(repository = repository)

    @Provides
    fun providesDeleteBookUseCase(
        repository: BookRepository
    ): DeleteBookUseCase = DeleteBookUseCase(repository = repository)
}