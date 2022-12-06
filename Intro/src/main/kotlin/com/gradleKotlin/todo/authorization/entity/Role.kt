package com.gradleKotlin.todo.authorization.entity

import com.gradleKotlin.todo.authorization.roles.RolesEnum
import javax.persistence.*

@Entity
@Table(name = "role")
data class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    @Enumerated(EnumType.STRING)
    var role: RolesEnum

)

