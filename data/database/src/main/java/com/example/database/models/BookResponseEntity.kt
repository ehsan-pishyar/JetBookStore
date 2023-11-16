package com.example.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.database.utils.DatabaseConstants

@Entity(tableName = DatabaseConstants.BOOKS_TABLE)
data class BookResponseEntity(
    val title: String?,
    val author: String?,
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val genre: String?,
    @ColumnInfo(name = "year_published")
    val yearPublished: Int?,
    @ColumnInfo(name = "checked_out")
    val checkedOut: Boolean?,
    @ColumnInfo(name = "created_at")
    val createdAt: String?
)
