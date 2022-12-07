package com.gradleKotlin.todo.dto

data class UserDto(
    val id: Long,

    var name: String?,

    val surname: String?,

    val email: String?,

    val password: String?,

    var token : String? = "",

    val todosList: MutableList<Long>?
)