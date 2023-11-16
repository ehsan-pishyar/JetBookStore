package com.example.domain.use_cases

import com.example.domain.models.BookResponse
import com.example.domain.repositories.BookRepository
import com.example.domain.utils.ServiceResult
import com.example.domain.utils.asServiceResult
import kotlinx.coroutines.flow.Flow

class GetBookUseCase constructor(
    private val repository: BookRepository
) {

    operator fun invoke(id: String): Flow<ServiceResult<BookResponse>> =
        repository.getBook(id = id).asServiceResult()
}