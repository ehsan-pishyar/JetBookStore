package com.example.repository.mappers

import com.example.database.models.BookResponseEntity
import com.example.domain.models.BookResponse
import com.example.network.models.BookResponseDto

fun BookResponseDto.toEntity(): BookResponseEntity =
    BookResponseEntity(
        this.title,
        this.author,
        this.id,
        this.genre,
        this.yearPublished,
        this.checkedOut,
        this.createdAt
    )

fun BookResponseEntity.toDomain(): BookResponse =
    BookResponse(
        this.title,
        this.author,
        this.id,
        this.genre,
        this.yearPublished,
        this.checkedOut,
        this.createdAt
    )

fun BookResponse.toDto(): BookResponseDto =
    BookResponseDto(
        this.title,
        this.author,
        this.id,
        this.genre,
        this.yearPublished,
        this.checkedOut,
        this.createdAt
    )

fun BookResponseDto.toDomain(): BookResponse =
    BookResponse(
        this.title,
        this.author,
        this.id,
        this.genre,
        this.yearPublished,
        this.checkedOut,
        this.createdAt
    )