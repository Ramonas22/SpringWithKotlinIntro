package com.gradleKotlin.todo.controller

import com.gradleKotlin.todo.dto.UserDto
import com.gradleKotlin.todo.services.UserServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000", "http://127.0.0.1:3000"])
@RestController
@RequestMapping("/User")
class UserController {

    @Autowired
    private lateinit var services: UserServices

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserDto? {
        return services.findUserById(id)
    }

    @GetMapping("/")
    fun getAllUsers(): MutableList<UserDto>? {
        return services.getAllUsers()
    }

    @PostMapping("/create")
    fun addUser(@RequestBody user: UserDto?): UserDto? {
        return services.addUser(user)
    }

    @PutMapping("/update")
    fun updateUser(@RequestBody user: UserDto): UserDto? {
        return services.updateUser(user)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long) {
        services.deleteUserById(id)
    }
}