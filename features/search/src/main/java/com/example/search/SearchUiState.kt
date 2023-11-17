package com.example.search

import com.example.domain.models.BookResponse

sealed interface SearchUiState {
    object Loading: SearchUiState
    data class Success (val books: List<BookResponse>): SearchUiState
    data class Error (val throwable: Throwable?): SearchUiState
}

data class MainSearchUiState(
    val response: SearchUiState
)