package com.gradleKotlin.todo.entities

import com.gradleKotlin.todo.authorization.entity.Role
import javax.persistence.*


@Entity
@Table(name = "Todo_app_users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long = 0,

    @Column(name ="name")
    val name: String? = "",

    @Column(name ="surname")
    val surname: String?= "",

    @Column(name ="email")
    var email: String?= "",

    @Column(name ="password")
    var password: String? = null,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_todos")
    val userTodos: MutableList<TodoApp>? = null,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name ="user_roles_table",
        joinColumns = [JoinColumn(name ="user_id")],
        inverseJoinColumns = [JoinColumn(name = "role_id")]
    )
    @Column(name = "role")
    var role:  MutableList<Role>? = null
)
