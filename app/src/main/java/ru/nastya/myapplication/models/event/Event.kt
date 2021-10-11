package ru.nastya.myapplication.models.event

import java.util.*

data class Event(
    var title: String,
    var desc: String,
    val dateStart: Date
)

