package com.example.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.database.models.BookResponseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBook(books: List<BookResponseEntity>)

    @Query("""
        UPDATE `books` SET 
        title = :title,
        author = :author,
        genre = :genre,
        year_published = :yearPublished,
        checked_out = :checkedOut,
        created_at = :createdAt
        WHERE id = :id
    """)
    suspend fun updateBook(
        id: String,
        title: String,
        author: String,
        genre: String,
        yearPublished: String,
        checkedOut: String,
        createdAt: String
    )

    @Query("SELECT * FROM `books`")
    fun fetchBooks(): Flow<List<BookResponseEntity>>

    @Query("SELECT * FROM `books` WHERE checked_out = :checkedOut")
    fun fetchCheckedOutBooks(checkedOut: Boolean = true): Flow<List<BookResponseEntity>>

    @Query("SELECT * FROM `books` WHERE id = :id")
    fun fetchBook(id: String): Flow<BookResponseEntity>

    @Query("DELETE FROM `books` WHERE id = :id")
    suspend fun deleteBook(id: String)

    @Query("DELETE FROM `books`")
    suspend fun clearBooks()

    @Transaction
    suspend fun deleteAndInsertBooks(
        books: List<BookResponseEntity>
    ) {
        clearBooks()
        insertBook(books = books)
    }
}