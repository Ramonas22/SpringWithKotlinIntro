package com.gradleKotlin.universityProject.models

import javax.persistence.*

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "first_name")
    val firstName: String?,

    @Column(name = "last_name")
    val lastName: String?,

    @Column(name = "personal_code")
    val personalCode: String?,

    @Column(name = "course")
    val course: String?,

    @ManyToMany
    @JoinTable(
        name ="universities_students",
        joinColumns = [JoinColumn(name ="student_id")],
        inverseJoinColumns = [JoinColumn(name = "university_id")]
    )
    @Column(name = "universities")
    val universities: MutableList<University>?
)
