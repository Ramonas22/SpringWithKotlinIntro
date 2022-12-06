package com.gradleKotlin.todo.authorization.controllers

import com.gradleKotlin.todo.authorization.dto.SignUpDto
import com.gradleKotlin.todo.authorization.services.AuthServices
import com.gradleKotlin.todo.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController {

    @Autowired
    private lateinit var authServices: AuthServices

    @PostMapping("/signup")
    fun signup(@RequestBody signUpDto: SignUpDto): User {
        return authServices.signUp(signUpDto)
    }
}