package com.example.repository.repository

import com.example.database.dao.BookDao
import com.example.database.models.BookResponseEntity
import com.example.domain.models.BookResponse
import com.example.domain.repositories.BookRepository
import com.example.network.ApiService
import com.example.network.models.BookResponseDto
import com.example.repository.mappers.toDomain
import com.example.repository.mappers.toDto
import com.example.repository.mappers.toEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class BookRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val dao: BookDao
): BookRepository {

    override suspend fun addBook(book: BookResponse) {
        api.insertBook(book = book.toDto())
    }

    override suspend fun updateBook(id: String, book: BookResponse) {
        api.updateBook(id = id, book = book.toDto())
    }

    override fun getBooks(): Flow<List<BookResponse>> {
        return dao.fetchBooks().map { booksEntity ->
            booksEntity.map(BookResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshBooks()
            }
        }
    }

    override fun getCheckedOutBooks(): Flow<List<BookResponse>> {
        return dao.fetchCheckedOutBooks().map { booksEntity ->
            booksEntity.map(BookResponseEntity::toDomain)
        }.onEach {
            if (it.isEmpty()) {
                refreshBooks()
            }
        }
    }

    override fun getBook(id: String): Flow<BookResponse> {
        return dao.fetchBook(id = id).map(BookResponseEntity::toDomain)
    }

    override suspend fun deleteBook(id: String) {
        api.deleteBook(id = id)
        dao.deleteBook(id = id)
    }

    override suspend fun refreshBooks() {
        api.getBooks().also {
            dao.deleteAndInsertBooks(books = it.map(BookResponseDto::toEntity))
        }
    }
}