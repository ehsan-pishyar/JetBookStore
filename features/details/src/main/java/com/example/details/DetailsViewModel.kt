package com.example.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.GetBookUseCase
import com.example.domain.use_cases.GetBooksUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val getBookUseCase: GetBookUseCase,
    private val getBooksUseCase: GetBooksUseCase
): ViewModel() {

    private val _detailsUiState = MutableStateFlow(MainDetailsUiState(DetailsUiState.Loading))
    val detailsUiState = _detailsUiState.asStateFlow()

    private val _bookId = MutableStateFlow("")
    val bookId = _bookId.asStateFlow()

    private val _booksUiState = MutableStateFlow(MainBooksUiState(BooksUiState.Loading))
    val booksUiState = _booksUiState.asStateFlow()

    init {
        getBooks()
    }

    fun getBookDetails(id: String) {
        viewModelScope.launch {
            getBookUseCase.invoke(id = id).collect { details ->
                val result = when (details) {
                    ServiceResult.Loading -> DetailsUiState.Loading
                    is ServiceResult.Success -> DetailsUiState.Success(
                        details = details.data
                    )
                    is ServiceResult.Error -> DetailsUiState.Error(
                        throwable = details.throwable
                    )
                }
                _detailsUiState.value = MainDetailsUiState(response = result)
            }
        }
    }

    fun addBookId(id: String) {
        _bookId.value = id
    }

    private fun getBooks() {
        viewModelScope.launch {
            getBooksUseCase.invoke().collect { books ->
                val result = when (books) {
                    ServiceResult.Loading -> BooksUiState.Loading
                    is ServiceResult.Success -> BooksUiState.Success(
                        books = books.data
                    )
                    is ServiceResult.Error -> BooksUiState.Error(
                        throwable = books.throwable
                    )
                }
                _booksUiState.value = MainBooksUiState(response = result)
            }
        }
    }
}