package com.example.network.models


data class BookResponseDto(
    val title: String?,
    val author: String?,
    val id: String,
    val genre: String?,
    val yearPublished: Int?,
    val checkedOut: Boolean?,
    val createdAt: String?
)