package com.example.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_cases.GetBooksUseCase
import com.example.domain.use_cases.GetCheckedOutBooksUseCase
import com.example.domain.utils.ServiceResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase,
    private val getCheckedOutBooksUseCase: GetCheckedOutBooksUseCase
): ViewModel() {

    private val _allBooksUiState = MutableStateFlow(MainAllBooksUiState(AllBooksUiState.Loading))
    val allBooksUiState = _allBooksUiState.asStateFlow()

    private val _checkedOutBooksUiState = MutableStateFlow(MainCheckedOutBooksUiState(CheckedOutBooksUiState.Loading))
    val checkedOutBooksUiState = _checkedOutBooksUiState.asStateFlow()

    init {
        getAllBooks()
        getCheckedOutBooks()
    }

    private fun getAllBooks() {
        viewModelScope.launch {
            getBooksUseCase.invoke().collect { booksResult ->
                val result = when (booksResult) {
                    ServiceResult.Loading -> AllBooksUiState.Loading
                    is ServiceResult.Success -> AllBooksUiState.Success(
                        books = booksResult.data
                    )
                    is ServiceResult.Error -> AllBooksUiState.Error(
                        throwable = booksResult.throwable
                    )
                }
                _allBooksUiState.value = MainAllBooksUiState(result)
            }
        }
    }

    private fun getCheckedOutBooks() {
        viewModelScope.launch {
            getCheckedOutBooksUseCase.invoke().collect { checkedOutResult ->
                val result = when (checkedOutResult) {
                    ServiceResult.Loading -> CheckedOutBooksUiState.Loading
                    is ServiceResult.Success -> CheckedOutBooksUiState.Success(
                        books = checkedOutResult.data
                    )
                    is ServiceResult.Error -> CheckedOutBooksUiState.Error(
                        throwable = checkedOutResult.throwable
                    )
                }
                _checkedOutBooksUiState.value = MainCheckedOutBooksUiState(result)
            }
        }
    }
}