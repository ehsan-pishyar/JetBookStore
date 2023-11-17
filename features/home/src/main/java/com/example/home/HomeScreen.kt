package com.example.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.SharedViewModel
import com.example.design_system.Background
import com.example.design_system.Primary
import com.example.design_system.carouselBooksSize
import com.example.design_system.carouselCheckedOutBooksSize
import com.example.design_system.components.CustomBookGridStyle
import com.example.design_system.components.CustomBookListStyle
import com.example.design_system.components.CustomFadeButton
import com.example.design_system.components.CustomHeader
import com.example.design_system.components.CustomText

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toSearchScreen: () -> Unit,
    toDetailsScreen: () -> Unit
) {
    val allBooksUiState: MainAllBooksUiState by viewModel.allBooksUiState.collectAsStateWithLifecycle()
    val checkedOutUiState: MainCheckedOutBooksUiState by viewModel.checkedOutBooksUiState.collectAsStateWithLifecycle()

    HomeContent(
        sharedViewModel = sharedViewModel,
        allBooksUiState = allBooksUiState,
        checkedOutBooksUiState = checkedOutUiState,
        toSearchScreen = toSearchScreen,
        toDetailsScreen = toDetailsScreen
    )
}

@Composable
fun HomeContent(
    sharedViewModel: SharedViewModel? = null,
    allBooksUiState: MainAllBooksUiState? = null,
    checkedOutBooksUiState: MainCheckedOutBooksUiState? = null,
    toSearchScreen: () -> Unit,
    toDetailsScreen: () -> Unit
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
            ) {
                Card(modifier = Modifier
                    .fillMaxSize(),
                    shape = RoundedCornerShape(bottomStart = 40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Primary
                    )
                ) {
                    // Header Section
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(10.dp)
                    ) {
                        CustomHeader(
                            hasBackButton = false,
                            toSearchScreen = { toSearchScreen() }
                        )
                    }
                    // Home description section
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(horizontal = 20.dp)
                    ) {
                        CustomText(
                            text = "چی میخوای بخونی؟",
                            fontSize = 25,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                    // Checked out products Section
                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(20.dp),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        CustomFadeButton(
                            text = "Checked Out"
                        )
                    }

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .weight(3f)
                        .padding(20.dp),
                        verticalArrangement = Arrangement.Top
                    ) {
                        when (val checkedOutBooksState = checkedOutBooksUiState!!.response) {
                            CheckedOutBooksUiState.Loading -> {
                                Column(modifier = Modifier
                                    .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    CustomText(
                                        text = "در حال بارگذاری کتاب ها ...",
                                        fontSize = 14,
                                        color = Color.White
                                    )
                                }
                            }
                            is CheckedOutBooksUiState.Success -> {
                                LazyRow(
                                    contentPadding = PaddingValues(0.dp),
                                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                                    userScrollEnabled = true,
                                    content = {
                                        items(count = carouselCheckedOutBooksSize(
                                            size = checkedOutBooksState.books.size
                                        )) { position ->
                                            CustomBookListStyle(
                                                title = "${checkedOutBooksState.books[position].title}",
                                                toDetailsScreen = {
                                                    sharedViewModel?.addBookId(checkedOutBooksState.books[position].id)
                                                    toDetailsScreen()
                                                }
                                            )
                                        }
                                    }
                                )
                            }
                            is CheckedOutBooksUiState.Error -> {
                                Column(modifier = Modifier
                                    .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    CustomText(
                                        text = "${checkedOutBooksState.throwable?.message}",
                                        fontSize = 14,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            }
            
            // All Books Section (Grid layout)
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(6f)
                .padding(20.dp)
            ) {
                // All Books title section
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                ) {
                    CustomText(
                        text = "همه کتاب ها",
                        fontSize = 20,
                        fontWeight = FontWeight.Bold
                    )
                }
                // All Books content section
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .weight(5f)
                ) {
                    when (val allBooksState = allBooksUiState!!.response) {
                        AllBooksUiState.Loading -> {
                            Column(modifier = Modifier
                                .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CustomText(
                                    text = "در حال بارگذاری کتاب ها ...",
                                    fontSize = 14,
                                    color = Color.White
                                )
                            }
                        }
                        is AllBooksUiState.Success -> {
                            LazyRow(
                                contentPadding = PaddingValues(0.dp),
                                horizontalArrangement = Arrangement.spacedBy(20.dp),
                                userScrollEnabled = true,
                                content = {
                                    items(count = carouselBooksSize(
                                        size = allBooksState.books.size
                                    )
                                    ) { position ->
                                        CustomBookGridStyle(
                                            title = "${allBooksState.books[position].title}",
                                            toDetailsScreen = {
                                                sharedViewModel?.addBookId(allBooksState.books[position].id)
                                                toDetailsScreen()
                                            }
                                        )
                                    }
                                }
                            )
                        }
                        is AllBooksUiState.Error -> {
                            Column(modifier = Modifier
                                .fillMaxSize(),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                CustomText(
                                    text = "${allBooksState.throwable?.message}",
                                    fontSize = 14,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun Preview_HomeContent() {
    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        HomeContent(
            toSearchScreen = {},
            toDetailsScreen = {}
        )
    }
}