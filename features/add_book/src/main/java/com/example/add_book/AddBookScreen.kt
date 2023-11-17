package com.example.add_book

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.getCurrentDate
import com.example.design_system.Background
import com.example.design_system.RedColor
import com.example.design_system.Secondary
import com.example.design_system.components.CustomButton
import com.example.design_system.components.CustomSpacer
import com.example.design_system.components.CustomText
import com.example.design_system.components.CustomTextField
import com.example.domain.models.BookResponse

@Composable
fun AddBookScreen(
    viewModel: AddBookViewModel = hiltViewModel()
) {
    val idText by viewModel.idText.collectAsStateWithLifecycle()
    val titleText by viewModel.titleText.collectAsStateWithLifecycle()
    val authorText by viewModel.authorText.collectAsStateWithLifecycle()
    val genreText by viewModel.genreText.collectAsStateWithLifecycle()
    val yearPublishedText by viewModel.yearPublishedText.collectAsStateWithLifecycle()

    val bookUiState: MainBookUiState by viewModel.booksUiState.collectAsStateWithLifecycle()

    var resultText by remember { mutableStateOf("") }

    when (val bookState = bookUiState.response) {
        BookUiState.Loading -> { resultText = "loading ..." }
        is BookUiState.Success -> {
            resultText = "موفق"
        }
        is BookUiState.Error -> {
            resultText = bookState.throwable!!.message!!
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            CustomTextField(
                placeholder = "شناسه کتاب رو وارد کن",
                onValueChange = viewModel::onIdValueChange,
                value = idText
            )
            CustomTextField(
                placeholder = "عنوان کتاب رو وارد کن",
                onValueChange = viewModel::onTitleValueChange,
                value = titleText
            )
            CustomTextField(
                placeholder = "نویسنده کتاب رو وارد کن",
                onValueChange = viewModel::onAuthorValueChange,
                value = authorText
            )
            CustomTextField(
                placeholder = "ژانر کتاب رو وارد کن",
                onValueChange = viewModel::onGenreValueChange,
                value = genreText
            )
            CustomTextField(
                placeholder = "سال عرضه کتاب رو وارد کن",
                title = "year published",
                onValueChange = viewModel::onYearPublishedValueChange,
                value = "$yearPublishedText",
                keyboardType = KeyboardType.Number
            )
            CustomSpacer()
            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CustomButton(
                    text = "افزودن",
                    onClick = {
                        viewModel.addBook(
                            book = BookResponse(
                                id = idText,
                                title = titleText,
                                author = authorText,
                                genre = genreText,
                                yearPublished = yearPublishedText,
                                createdAt = getCurrentDate(),
                                checkedOut = false
                            )
                        )

                    }
                )
                CustomButton(
                    text = "آپدیت",
                    onClick = {
                        viewModel.updateBook(
                            id = idText,
                            book = BookResponse(
                                id = idText,
                                title = titleText,
                                author = authorText,
                                genre = genreText,
                                yearPublished = yearPublishedText,
                                createdAt = getCurrentDate(),
                                checkedOut = false
                            )
                        )
                        viewModel.refreshBooks()
                    },
                    color = Secondary
                )
                CustomButton(
                    text = "پاک کردن",
                    onClick = {
                        viewModel.deleteBook(id = idText)
                        viewModel.refreshBooks()
                    },
                    color = RedColor
                )
            }
        }
    }
}