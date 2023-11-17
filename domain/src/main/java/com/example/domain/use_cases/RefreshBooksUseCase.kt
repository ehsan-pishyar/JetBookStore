package com.example.domain.use_cases

import com.example.domain.repositories.BookRepository

class RefreshBooksUseCase constructor(
    private val repository: BookRepository
) {

    suspend operator fun invoke() = repository.refreshBooks()
}