package com.gradleKotlin.todo.mappers

import com.gradleKotlin.todo.dto.TodoAppDto
import com.gradleKotlin.todo.entities.TodoApp
import com.gradleKotlin.todo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoAppMapper {

    @Autowired
    private lateinit var userRepo: UserRepository

    fun todoAppToDto(todo : TodoApp?) : TodoAppDto?{
        return if(todo != null){
            return TodoAppDto(todo.id, todo.type, todo.content, todo.endDate, todo.user.id)
        }else{
            null
        }
    }

    fun dtoToTodoApp(todo : TodoAppDto?) : TodoApp?{
        return if(todo != null){
            return TodoApp(todo.id, todo.type, todo.content, todo.endDate, userRepo.findById(todo.key).orElse(null))
        }else{
            null
        }
    }

    fun todoAppListToDtoList(todos : MutableList<TodoApp>?) : MutableIterable<TodoAppDto>?{
        val todosDto : MutableList<TodoAppDto> = arrayListOf()
        return if(todos != null){
            todos.forEach {
                todoAppToDto(it)?.let {it1-> todosDto.add(it1)}
            }
            todosDto
        }else{
            null
        }

    }
}