package com.gradleKotlin.todo.dto

import java.util.*

data class TodoAppDto(
    val id: Long,

    val type: String?,

    val content: String?,

    val endDate: Date?,

    val key: Long
)
