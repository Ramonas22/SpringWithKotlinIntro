package com.gradleKotlin.universityProject.models

data class StudentDto(
    var id: Long,

    val firstName: String?,

    val lastName: String?,

    val personalCode: String?,

    val course: String?
)
