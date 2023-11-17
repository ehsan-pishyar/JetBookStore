package com.example.core

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {

    var bookId by mutableStateOf("")
        private set

    fun addBook(id: String) {
        bookId = id
    }
}