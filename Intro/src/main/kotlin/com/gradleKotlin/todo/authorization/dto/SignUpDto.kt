package com.gradleKotlin.todo.authorization.dto

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class SignUpDto(
    @NotBlank
    @Email
    @Size(max = 50)
    val email: String? = null,

    @NotBlank
    @Size(min = 6, max = 20)
    val password: String? = null,

    @NotBlank
    @Size(min = 6, max = 20)
    val repeatPassword: String? = null

)
