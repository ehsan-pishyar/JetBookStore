package com.example.network

import com.example.network.models.BookResponseDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    // Get all books from webservice
    @GET("books")
    suspend fun getBooks(): List<BookResponseDto>

    // Get single book by its id from webservice
    @GET("books/{id}")
    suspend fun getBook(
        @Path("id") id: String
    ): BookResponseDto

    // Insert book to webservice
    @POST("books")
    suspend fun insertBook(
        @Body book: BookResponseDto
    ): BookResponseDto

    @PUT("books/{id}")
    suspend fun updateBook(
        @Path("id") id: String,
        @Body book: BookResponseDto
    ): BookResponseDto

    @DELETE("books/{id}")
    suspend fun deleteBook(
        @Path("id") id: String
    )
}