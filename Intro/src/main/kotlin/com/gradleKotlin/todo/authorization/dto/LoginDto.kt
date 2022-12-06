package com.gradleKotlin.todo.authorization.dto

import javax.validation.constraints.NotBlank

data class LoginDto(

    @NotBlank
    val email: String? = null,

    @NotBlank
    val password : String? = null

)
