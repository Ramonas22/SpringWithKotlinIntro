package com.gradleKotlin.universityProject.models

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class University(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id : Long,

    @Column(name = "name")
    val name : String?,

    @Column(name = "address")
    val address : String?,

    @Column(name = "rating")
    val rating : Int?,

    @Column(name = "establishmentYear")
    val foundationYear : Int?,

    //Will be implemented later
    /*
    @Column(name = "lecturers")
    val lecturers : MutableList<Lecturer>?,

    @Column(name = "students")
    val students : MutableList<Student>?

     */
)
