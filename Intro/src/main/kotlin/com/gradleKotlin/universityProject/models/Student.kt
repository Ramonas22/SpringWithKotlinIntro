package com.gradleKotlin.universityProject.models

import javax.persistence.*

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name = "first_name")
    val firstName: String? = null,

    @Column(name = "last_name")
    val lastName: String? = null,

    @Column(name = "personal_code")
    val personalCode: String? = null,

    @Column(name = "course")
    val course: String? = null,

    @ManyToMany
    @JoinTable(
        name ="universities_students",
        joinColumns = [JoinColumn(name ="student_id")],
        inverseJoinColumns = [JoinColumn(name = "university_id")]
    )
    @Column(name = "universities")
    val universities: MutableList<University>? = null,

    @ManyToMany(mappedBy = "studentsEnrolled")
    @Column(name = "courses")
    val courses: MutableList<Course>? = null
)
