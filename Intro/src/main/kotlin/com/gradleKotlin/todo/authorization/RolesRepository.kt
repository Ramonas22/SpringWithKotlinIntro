package com.gradleKotlin.todo.authorization

import com.gradleKotlin.todo.authorization.entity.Role
import com.gradleKotlin.todo.authorization.roles.RolesEnum
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface RolesRepository : CrudRepository<Role, Long> {
    fun findByRole(role: RolesEnum): Role?
}