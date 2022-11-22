package com.gradleKotlin.todo.mappers

import com.gradleKotlin.todo.dto.TodoAppDto
import com.gradleKotlin.todo.entities.TodoApp
import org.springframework.stereotype.Service

@Service
class TodoAppMapper {

    fun todoAppToDto(todo : TodoApp?) : TodoAppDto?{
        return if(todo != null){
            return TodoAppDto(todo.id, todo.type, todo.content, todo.endDate, todo.key)
        }else{
            null
        }
    }

    fun dtoToTodoApp(todo : TodoAppDto?) : TodoApp?{
        return if(todo != null){
            return TodoApp(todo.id, todo.type, todo.content, todo.endDate, todo.key)
        }else{
            null
        }
    }

    fun todoAppListToDtoList(todos : MutableList<TodoApp>?) : MutableIterable<TodoAppDto>?{
        var todosDto : MutableList<TodoAppDto> = arrayListOf()
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