package com.example.add_book

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.BookResponse
import com.example.domain.use_cases.AddBookUseCase
import com.example.domain.use_cases.DeleteBookUseCase
import com.example.domain.use_cases.GetBookUseCase
import com.example.domain.use_cases.RefreshBooksUseCase
import com.example.domain.use_cases.UpdateBookUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBookViewModel @Inject constructor(
    private val addBookUseCase: AddBookUseCase,
    private val updateBookUseCase: UpdateBookUseCase,
    private val deleteBookUseCase: DeleteBookUseCase,
    private val refreshBooksUseCase: RefreshBooksUseCase,
    private val getBookUseCase: GetBookUseCase
): ViewModel() {

    private val _idText = MutableStateFlow("")
    val idText = _idText.asStateFlow()

    private val _titleText = MutableStateFlow("")
    val titleText = _titleText.asStateFlow()

    private val _authorText = MutableStateFlow("")
    val authorText = _authorText.asStateFlow()

    private val _genreText = MutableStateFlow("")
    val genreText = _genreText.asStateFlow()

    private val _yearPublishedText = MutableStateFlow(0)
    val yearPublishedText = _yearPublishedText.asStateFlow()

    private val _bookUiState = MutableStateFlow(MainBookUiState(BookUiState.Loading))
    val booksUiState = _bookUiState.asStateFlow()

    fun addBook(book: BookResponse) {
        viewModelScope.launch {
            addBookUseCase.invoke(book = book).collect {
                val result = when (it) {
                    ServiceResult.Loading -> BookUiState.Loading
                    is ServiceResult.Success -> BookUiState.Success(
                        book = it.data
                    )
                    is ServiceResult.Error -> BookUiState.Error(
                        throwable = it.throwable
                    )
                }
                _bookUiState.value = MainBookUiState(response = result)
            }
        }
    }

    fun updateBook(id: String, book: BookResponse) {
        viewModelScope.launch {
            updateBookUseCase.invoke(id = id, book = book)
        }
    }

    fun deleteBook(id: String) {
        viewModelScope.launch {
            deleteBookUseCase.invoke(id = id)
        }
    }

    fun refreshBooks() {
        viewModelScope.launch {
            refreshBooksUseCase.invoke()
        }
    }

    fun getBook(id: String) {
        viewModelScope.launch {
            getBookUseCase.invoke(id = id).collect { bookResult ->
                val result = when (bookResult) {
                    ServiceResult.Loading -> BookUiState.Loading
                    is ServiceResult.Success -> BookUiState.Success(
                        book = bookResult.data
                    )
                    is ServiceResult.Error -> BookUiState.Error(
                        throwable = bookResult.throwable
                    )
                }
                _bookUiState.value = MainBookUiState(response = result)
            }
        }
    }

    fun onIdValueChange(id: String) {
        _idText.value = id
    }

    fun onTitleValueChange(title: String) {
        _titleText.value = title
    }

    fun onAuthorValueChange(author: String) {
        _authorText.value = author
    }

    fun onGenreValueChange(genre: String) {
        _genreText.value = genre
    }
    fun onYearPublishedValueChange(year: String) {
        if (year.isNotEmpty()) {
            _yearPublishedText.value = year.toInt()
        }
    }
}