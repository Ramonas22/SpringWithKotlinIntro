package com.gradleKotlin.universityProject.dto

data class UniversityDto(

    val id : Long,

    val name : String?,

    val address : String?,

    val rating : Int?,

    val foundationYear : Int?,

    //Will be implemented later
    /*
    val lecturers : MutableList<Lecturer>?,

    val students : MutableList<Student>?

     */
)
