package com.example.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.domain.models.BookResponse

class SharedViewModel: ViewModel() {

    var bookId by mutableStateOf("")
        private set

    fun addBookId(id: String) {
        bookId = id
    }
}