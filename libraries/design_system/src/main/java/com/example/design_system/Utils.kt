package com.example.design_system

fun carouselCheckedOutBooksSize(size: Int): Int =
    if (size >= 3) 3 else size

fun carouselBooksSize(size: Int): Int =
    if (size >= 7) 7 else size