package com.example.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.WhileUiSubscribed
import com.example.domain.models.BookResponse
import com.example.domain.use_cases.GetBooksUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {

    private val _booksUiState = MutableStateFlow(MainSearchUiState(SearchUiState.Loading))
    val booksUiState = _booksUiState.asStateFlow()

    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()

    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()

    private val _books = MutableStateFlow(emptyList<BookResponse>())
    val books = searchText
        .debounce(1000)
        .onEach { _isSearching.update { true } }
        .combine(_books) { text, books ->
            if (text.isEmpty() || text.isBlank()) {
                books
            } else {
                delay(1000)
                books.filter { booksResponse ->
                    booksResponse.doesMatchSearchQuery(text)
                }
            }
        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            scope = viewModelScope,
            started = WhileUiSubscribed,
            initialValue = _books.value
        )

    init {
        getBooks()
    }

    private fun getBooks() {
        viewModelScope.launch {
            getBooksUseCase.invoke().collect { books ->
                val result = when (books) {
                    ServiceResult.Loading -> SearchUiState.Loading
                    is ServiceResult.Success -> SearchUiState.Success(
                        books = books.data
                    )
                    is ServiceResult.Error -> SearchUiState.Error(
                        throwable = books.throwable
                    )
                }
                _booksUiState.value = MainSearchUiState(response = result)
            }
        }
    }

    fun addBooks(books: List<BookResponse>) {
        _books.value = books
    }

    fun onSearchTextChanged(text: String) {
        _searchText.value = text
    }
}