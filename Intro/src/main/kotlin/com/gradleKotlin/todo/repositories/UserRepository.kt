package com.gradleKotlin.todo.repositories

import com.gradleKotlin.todo.entities.User
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface UserRepository : CrudRepository<User, Long> {
    fun findByEmail(email:String) : Optional<User>
}