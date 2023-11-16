package com.example.network.models


data class BookResponseDto(
    val author: String?,
    val checkedOut: Boolean?,
    val createdAt: String?,
    val genre: String?,
    val id: String?,
    val title: String?,
    val yearPublished: Int?
)