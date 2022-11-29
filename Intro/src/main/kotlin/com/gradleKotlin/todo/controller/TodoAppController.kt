package com.gradleKotlin.todo.controller

import com.gradleKotlin.todo.dto.TodoAppDto
import com.gradleKotlin.todo.services.TodoAppService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@CrossOrigin(origins = ["http://localhost:3000", "http://127.0.0.1:5500"])
@RestController
@RequestMapping("/Todo")
class TodoAppController {
    @Autowired
    private lateinit var services : TodoAppService

    @GetMapping("/{id}")
    fun getTodoById(@PathVariable id: Long) : TodoAppDto?{
        return services.findTodoById(id)
    }

    @GetMapping("/")
    fun getAllTodos():MutableList<TodoAppDto>?{
        return services.getAllTodos()
    }
    @GetMapping("/tasks/{id}")
    fun getTodosByUserId(@PathVariable id: Long): MutableList<TodoAppDto>?{
        return services.getTodosByUserId(id)
    }

    @PostMapping("/create")
    fun addTodo(@RequestBody todoAppDto: TodoAppDto) : TodoAppDto?{
        return services.addTodo(todoAppDto)
    }

    @PutMapping("/update")
    fun updateTodo(@RequestBody todoAppDto: TodoAppDto) : TodoAppDto?{
        return services.updateTodo(todoAppDto)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteTodoById(@PathVariable id: Long){
        services.deleteTodoById(id)
    }
}