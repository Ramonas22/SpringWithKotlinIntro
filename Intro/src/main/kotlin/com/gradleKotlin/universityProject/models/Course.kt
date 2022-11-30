package com.gradleKotlin.universityProject.models

import javax.persistence.*

@Entity
data class Course(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id : Long,

    @Column(name = "title")
    val title: String? = null,

    @Column(name = "credits")
    val credits: Int? = null,

    @ManyToMany
    @JoinTable(
        name ="courses_students",
        joinColumns = [JoinColumn(name ="course_id")],
        inverseJoinColumns = [JoinColumn(name = "student_id")]
    )
    @Column(name = "students_enrolled")
    val studentsEnrolled: MutableList<Student>? = null
)
