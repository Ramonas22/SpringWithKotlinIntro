package com.gradleKotlin.todo.repositories

import com.gradleKotlin.todo.entities.TodoApp
import org.springframework.data.repository.CrudRepository

interface TodoAppRepository : CrudRepository<TodoApp, Long> {

    fun findALlByUser_Id(id: Long) : MutableList<TodoApp>?
}