package com.example.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.SharedViewModel
import com.example.design_system.Background
import com.example.design_system.components.CustomText
import com.example.design_system.R
import com.example.design_system.components.CustomSpacer
import com.example.design_system.components.CustomTextField
import com.example.domain.models.BookResponse

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toDetailsScreen: () -> Unit
) {
    val booksUiState: MainSearchUiState by viewModel.booksUiState.collectAsStateWithLifecycle()
    val searchText by viewModel.searchText.collectAsStateWithLifecycle()
    val isSearching by viewModel.isSearching.collectAsStateWithLifecycle()
    val books by viewModel.books.collectAsStateWithLifecycle()

    when (val booksState = booksUiState.response) {
        SearchUiState.Loading -> {}
        is SearchUiState.Success -> {
            viewModel.addBooks(books = booksState.books)
        }
        is SearchUiState.Error -> {}
    }

    SearchContent(
        viewModel = viewModel,
        sharedViewModel = sharedViewModel,
        searchText = searchText,
        isSearching = isSearching,
        books = books,
        toDetailsScreen = { toDetailsScreen() }
    )
}

@Composable
fun SearchContent(
    viewModel: SearchViewModel? = null,
    sharedViewModel: SharedViewModel? = null,
    searchText: String = "",
    isSearching: Boolean = false,
    books: List<BookResponse> = emptyList(),
    toDetailsScreen: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp)
        ) {
            CustomTextField(
                placeholder = "اسم کتاب رو وارد کن ...",
                onValueChange = viewModel!!::onSearchTextChanged,
                value = searchText,
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null
                    )
                }
            )
            CustomSpacer()
            if (isSearching) {
                Box(modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            } else {
                LazyColumn(
                    userScrollEnabled = true,
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    content = {
                        items(count = books.size) { position ->
                            ListItems(
                                title = "${books[position].title}",
                                onBookClick = {
                                    sharedViewModel?.addBookId(books[position].id)
                                    toDetailsScreen()
                                }
                            )
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun ListItems(
    title: String,
    onBookClick: () -> Unit
) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .height(90.dp)
        .clickable(enabled = true, onClick = { onBookClick() }),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
            horizontalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(1.2f),
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.book_image),
                    contentDescription = null,
                    modifier = Modifier.clip(shape = RoundedCornerShape(6.dp))
                )
            }

            Column(modifier = Modifier
                .fillMaxHeight()
                .weight(2.7f),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                CustomText(
                    text = title,
                    fontSize = 12,
                    fontWeight = FontWeight.Medium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}

@Preview
@Composable
private fun Preview_SearchContent() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        SearchContent(
            toDetailsScreen = {}
        )
    }
}