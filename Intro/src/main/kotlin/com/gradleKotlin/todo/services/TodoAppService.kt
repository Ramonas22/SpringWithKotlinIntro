package com.gradleKotlin.todo.services

import com.gradleKotlin.todo.dto.TodoAppDto
import com.gradleKotlin.todo.entities.TodoApp
import com.gradleKotlin.todo.mappers.TodoAppMapper
import com.gradleKotlin.todo.repositories.TodoAppRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class TodoAppService {
    @Autowired
    private lateinit var mapper: TodoAppMapper

    @Autowired
    private lateinit var todoRepo: TodoAppRepository

    fun addTodo(todo: TodoAppDto?) : TodoAppDto?{
        return mapper.todoAppToDto( mapper.dtoToTodoApp(todo)?.let { todoRepo.save(it) })
    }

    fun findTodoById(id : Long) : TodoAppDto?{
        return mapper.todoAppToDto(todoRepo.findByIdOrNull(id))
    }

    fun getAllTodos() : MutableList<TodoAppDto>? {
        return mapper.todoAppListToDtoList(todoRepo.findAll().toMutableList()) as MutableList<TodoAppDto>
    }

    fun updateTodo(todo: TodoAppDto) : TodoAppDto?{
        return if(todoRepo.existsById(todo.id)){
            mapper.todoAppToDto( mapper.dtoToTodoApp(todo)?.let { todoRepo.save(it) })
        }else{
            null
        }
    }

    fun deleteTodoById(id : Long){
        if(todoRepo.existsById(id)){
            todoRepo.deleteById(id)
            print("Success")
        }else{
            print("Failed to delete Todo with provided id")
        }
    }

    fun getTodosByUserId(id: Long): MutableList<TodoAppDto>? {
        return mapper.todoAppListToDtoList(todoRepo.findALlByUser_Id(id) as MutableList<TodoApp>) as MutableList<TodoAppDto>
    }
}