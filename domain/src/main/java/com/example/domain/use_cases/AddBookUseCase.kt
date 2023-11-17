package com.example.domain.use_cases

import com.example.domain.models.BookResponse
import com.example.domain.repositories.BookRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asServiceResult
import kotlinx.coroutines.flow.Flow

class AddBookUseCase constructor(
    private val repository: BookRepository
) {
    suspend operator fun invoke(book: BookResponse): Flow<ServiceResult<BookResponse>> =
        repository.addBook(book = book).asServiceResult()
}