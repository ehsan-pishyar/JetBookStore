package com.example.domain.repositories

import com.example.domain.models.BookResponse
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    suspend fun addBook(book: BookResponse): Flow<BookResponse>
    suspend fun updateBook(
        id: String,
        book: BookResponse
    )
    fun getBooks(): Flow<List<BookResponse>>
    fun getCheckedOutBooks(): Flow<List<BookResponse>>
    fun getBook(id: String): Flow<BookResponse>
    suspend fun deleteBook(id: String)
    suspend fun refreshBooks()
}