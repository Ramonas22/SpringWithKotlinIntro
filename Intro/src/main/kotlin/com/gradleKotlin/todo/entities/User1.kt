package com.gradleKotlin.todo.entities

import javax.persistence.*


@Entity
@Table(name = "Todo_app_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long,

    @Column(name ="name")
    val name: String?,

    @Column(name ="surname")
    val surname: String?,

    @Column(name ="email")
    val email: String?,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_todos")
    val userTodos: MutableList<TodoApp>?
)
