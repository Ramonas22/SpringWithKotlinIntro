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
    val name : String? = null,

    @field: NotBlank
    @field: Size(min = 2, message = "text is too short")
    @Column(name = "address")
    val address : String? = null,

    @Column(name = "rating")
    val rating : Int? = null,


    @Column(name = "establishmentYear")
    val foundationYear : Int? = null,

    @field: Email(message = "not email")
    @field: NotBlank(message = "blank")
    @Column(name = "email")
    val email : String? = null,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name ="universities_students",
        joinColumns = [JoinColumn(name = "university_id")],
        inverseJoinColumns = [JoinColumn(name ="student_id")]
    )
    @Column(name = "students")
    val students : MutableList<Student>? = null

    //Will be implemented later
    /*
    @Column(name = "lecturers")
    val lecturers : MutableList<Lecturer>?,



     */
)
