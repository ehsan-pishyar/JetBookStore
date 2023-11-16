package com.example.domain.use_cases

import com.example.domain.models.BookResponse
import com.example.domain.repositories.BookRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asServiceResult
import kotlinx.coroutines.flow.Flow

class GetBooksUseCase constructor(
    private val repository: BookRepository
) {

    operator fun invoke(): Flow<ServiceResult<List<BookResponse>>> =
        repository.getBooks().asServiceResult()
}