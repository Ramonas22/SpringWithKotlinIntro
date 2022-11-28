package com.gradleKotlin.universityProject.models

import javax.persistence.*
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
data class University(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id : Long,

    @Column(name = "name")
    val name : String?,

    @field: NotBlank
    @field: Size(min = 2, message = "text is too short")
    @Column(name = "address")
    val address : String?,

    @Column(name = "rating")
    val rating : Int?,


    @Column(name = "establishmentYear")
    val foundationYear : Int?,

    @field: Email(message = "not email")
    @field: NotBlank(message = "blank")
    @Column(name = "email")
    val email : String?,

    @ManyToMany(mappedBy = "universities", fetch = FetchType.LAZY)
    @Column(name = "students")
    val students : MutableList<Student>?

    //Will be implemented later
    /*
    @Column(name = "lecturers")
    val lecturers : MutableList<Lecturer>?,



     */
)
