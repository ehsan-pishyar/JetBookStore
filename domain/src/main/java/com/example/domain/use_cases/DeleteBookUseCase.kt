package com.example.domain.use_cases

import com.example.domain.repositories.BookRepository

class DeleteBookUseCase constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke(id: String) = repository.deleteBook(id = id)
}