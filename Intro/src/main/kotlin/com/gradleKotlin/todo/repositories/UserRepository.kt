package com.gradleKotlin.todo.repositories

import com.gradleKotlin.todo.entities.User1
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User1, Long> {
}