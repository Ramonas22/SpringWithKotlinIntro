package com.gradleKotlin.universityProject.dto

data class CourseDto(

    val id : Long,

    val title : String?,

    val credits : Int?,

    val studentsEnrolled : MutableList<Long>?
)
