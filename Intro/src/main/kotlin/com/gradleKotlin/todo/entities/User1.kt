package com.gradleKotlin.todo.entities

import javax.persistence.*


@Entity
data class User1(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name ="name")
    val name: String?,

    @Column(name ="surname")
    val surname: String?,

    @Column(name ="email")
    val email: String?
)
