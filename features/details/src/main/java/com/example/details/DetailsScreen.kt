package com.example.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.SharedViewModel
import com.example.design_system.Background
import com.example.design_system.IranYekan
import com.example.design_system.LighterGray
import com.example.design_system.Poppins
import com.example.design_system.Primary
import com.example.design_system.R
import com.example.design_system.carouselCheckedOutBooksSize
import com.example.design_system.components.CustomBookListStyle
import com.example.design_system.components.CustomFadeButton
import com.example.design_system.components.CustomHeader
import com.example.design_system.components.CustomRating
import com.example.design_system.components.CustomSpacer
import com.example.design_system.components.CustomText
import com.example.design_system.components.CustomViewed

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel = hiltViewModel(),
    sharedViewModel: SharedViewModel = SharedViewModel(),
    toSearchScreen: () -> Unit,
    toHomeScreen: () -> Unit
) {
    val booksUiState: MainBooksUiState by viewModel.booksUiState.collectAsStateWithLifecycle()
    viewModel.addBookId(id = sharedViewModel.bookId)
    val bookIdState by viewModel.bookId.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit) {
        viewModel.getBookDetails(id = bookIdState)
    }

    val detailsUiState: MainDetailsUiState by viewModel.detailsUiState.collectAsStateWithLifecycle()

    // To save author name
    var author by remember { mutableStateOf("") }
    // To save createdAt
    var date by remember { mutableStateOf("") }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Background)
    ) {
        Column(modifier = Modifier
            .fillMaxSize()
        ) {
            // Header Section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(10.dp)
            ) {
                CustomHeader(
                    hasBackButton = true,
                    toSearchScreen = { toSearchScreen() },
                    darkStyle = true,
                    onBackClicked = { toHomeScreen() }
                )
            }
            // Book image, title, rating, viewed section
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
                    .padding(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.book_image),
                    contentDescription = null,
                    modifier = Modifier.clip(shape = RoundedCornerShape(12.dp))
                )
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    when (val detailsState = detailsUiState.response) {
                        DetailsUiState.Loading -> {}
                        is DetailsUiState.Success -> {
                            // Title
                            CustomText(
                                text = "${detailsState.details.title}",
                                fontWeight = FontWeight.Medium,
                                fontSize = 18,
                                fontFamily = Poppins
                            )
                            author = detailsState.details.author!!
                            date = detailsState.details.createdAt!!
                        }

                        is DetailsUiState.Error -> {
                            println("${detailsState.throwable?.message}")
                        }
                    }
                    // Rating & viewed
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight(),
                        horizontalArrangement = Arrangement.spacedBy(20.dp)
                    ) {
                        CustomRating(
                            rate = 4.5f,
                            textSize = 12,
                            iconSize = 15,
                            modifier = Modifier.padding(top = 3.dp),
                            isRtl = false
                        )
                        CustomViewed(
                            textSize = 12,
                            iconSize = 15,
                            modifier = Modifier.padding(top = 3.dp),
                            isRtl = false
                        )
                    }
                    // Buy button
                    Button(
                        onClick = {},
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Primary
                        ),
                        contentPadding = PaddingValues(
                            horizontal = 20.dp,
                            vertical = 3.dp
                        )
                    ) {
                        CustomText(
                            text = "خرید سریع",
                            fontSize = 14,
                            color = Color.White
                        )
                    }
                }
            }
            // Book description section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(20.dp)
            ) {
                CustomText(
                    text = "لورم ایپسوم متن ساختگی با تولید سادگی نامفهوم از صنعت چاپ و با استفاده از طراحان گرافیک است چاپگرها و متون بلکه روزنامه و مجله در ستون و سطرآنچنان که لازم است و برای شرایط فعلی",
                    fontSize = 12,
                    fontFamily = IranYekan,
                    color = LighterGray,
                    textAlign = TextAlign.Justify
                )
                CustomSpacer(space = 10)
                Divider()
            }
            // Book author and date section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    // Author section
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.person),
                                contentDescription = null,
                                modifier = Modifier.size(50.dp),
                                tint = Primary
                            )
                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .weight(1f)
                            ) {
                                CustomFadeButton(
                                    text = "نویسنده",
                                    containerColor = Primary.copy(alpha = 0.2f),
                                    textColor = Color.Black
                                )
                                // Author
                                CustomText(
                                    text = author,
                                    fontSize = 12,
                                    maxLines = 1,
                                    fontFamily = Poppins,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }
                        }
                    }
                    // Date section
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxSize(),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            CustomText(
                                text = "تاریخ:",
                                fontSize = 12,
                            )
                            CustomText(
                                text = date,
                                fontSize = 12,
                                color = LighterGray
                            )
                        }
                    }
                }
            }
            // Similar books section
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(4f)
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize(),
                    shape = RoundedCornerShape(topStart = 40.dp, topEnd = 40.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Primary
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(20.dp)
                    ) {
                        CustomText(
                            text = "کتاب های مشابه",
                            fontSize = 18,
                            fontWeight = FontWeight.Medium,
                            color = Color.White
                        )
                        CustomSpacer(space = 30)

                        when (val booksState = booksUiState.response) {
                            BooksUiState.Loading -> {
                                Column(
                                    modifier = Modifier
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

                            is BooksUiState.Success -> {
                                LazyRow(
                                    contentPadding = PaddingValues(0.dp),
                                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                                    userScrollEnabled = true,
                                    content = {
                                        items(
                                            count = carouselCheckedOutBooksSize(
                                                size = booksState.books.size
                                            )
                                        ) { position ->
                                            CustomBookListStyle(
                                                title = "${booksState.books[position].title}",
                                                toDetailsScreen = {
                                                    sharedViewModel.addBookId(booksState.books[position].id)
                                                }
                                            )
                                        }
                                    }
                                )
                            }

                            is BooksUiState.Error -> {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    CustomText(
                                        text = "${booksState.throwable?.message}",
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
}