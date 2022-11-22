package com.gradleKotlin.universityProject.dto

import javax.validation.constraints.*

data class UniversityDto(

    val id : Long,

    val name : String?,

    @field: NotBlank
    @field: Size(min = 2, message = "text is too short")
    val address : String,

    val rating : Int?,

    val foundationYear : Int?,

    @field: Email(message = "not email")
    @field: NotBlank(message = "blank")
    val email :String

    //Will be implemented later
    /*
    val lecturers : MutableList<Lecturer>?,

    val students : MutableList<Student>?

     */
)
