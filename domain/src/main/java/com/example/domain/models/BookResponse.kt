package com.example.domain.models

data class BookResponse(
    val title: String?,
    val author: String?,
    val id: String,
    val genre: String?,
    val yearPublished: Int?,
    val checkedOut: Boolean?,
    val createdAt: String?
)
