package com.gradleKotlin.todo.entities

import java.util.*
import javax.persistence.*

@Entity
data class TodoApp(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    val id: Long,

    @Column(name ="type")
    val type: String?,

    @Column(name ="content")
    val content: String?,

    @Column(name ="endDate")
    val endDate: Date?,

    @Column(name ="key")
    val key: String
)