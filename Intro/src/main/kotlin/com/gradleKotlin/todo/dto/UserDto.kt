package com.gradleKotlin.todo.dto

data class UserDto(
    val id: Long,

    val name: String?,

    val surname: String?,

    val email: String?
)