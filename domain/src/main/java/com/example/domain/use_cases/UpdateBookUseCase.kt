package com.example.domain.use_cases

import com.example.domain.models.BookResponse
import com.example.domain.repositories.BookRepository

class UpdateBookUseCase constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke(id: String, book: BookResponse) =
        repository.updateBook(id = id, book = book)
}