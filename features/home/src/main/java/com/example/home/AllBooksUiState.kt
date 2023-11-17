package com.example.home

import com.example.domain.models.BookResponse

sealed interface AllBooksUiState {
    object Loading: AllBooksUiState
    data class Success (val books: List<BookResponse>): AllBooksUiState
    data class Error (val throwable: Throwable?): AllBooksUiState
}

data class MainAllBooksUiState(
    val response: AllBooksUiState
)

sealed interface CheckedOutBooksUiState {
    object Loading: CheckedOutBooksUiState
    data class Success (val books: List<BookResponse>): CheckedOutBooksUiState
    data class Error (val throwable: Throwable?): CheckedOutBooksUiState
}

data class MainCheckedOutBooksUiState(
    val response: CheckedOutBooksUiState
)

