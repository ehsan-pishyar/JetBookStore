package com.example.add_book

import com.example.domain.models.BookResponse

sealed interface BookUiState {
    object Loading: BookUiState
    data class Success (val book: BookResponse): BookUiState
    data class Error (val throwable: Throwable?): BookUiState
}

data class MainBookUiState(
    val response: BookUiState
)