package com.example.domain.use_cases

import com.example.domain.models.BookResponse
import com.example.domain.repositories.BookRepository

class AddBookUseCase constructor(
    private val repository: BookRepository
) {
    suspend operator fun invoke(book: BookResponse) =
        repository.addBook(book = book)
}