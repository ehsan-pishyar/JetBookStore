package com.example.core

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getCurrentDate(): String {
    val calendar = Calendar.getInstance()
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    return dateFormat.format(calendar.time)
}