package com.gradleKotlin.todo.repositories

import com.gradleKotlin.todo.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
}