package com.example.details

import com.example.domain.models.BookResponse

sealed interface DetailsUiState {
    object Loading: DetailsUiState
    data class Success (val details: BookResponse): DetailsUiState
    data class Error (val throwable: Throwable?): DetailsUiState
}

data class MainDetailsUiState(
    val response: DetailsUiState
)

sealed interface BooksUiState {
    object Loading: BooksUiState
    data class Success (val books: List<BookResponse>): BooksUiState
    data class Error (val throwable: Throwable?): BooksUiState
}

data class MainBooksUiState(
    val response: BooksUiState
)