package com.gradleKotlin.todo.authorization.controllers

import com.gradleKotlin.todo.authorization.config.jwt.JwtUtils
import com.gradleKotlin.todo.authorization.config.services.UserDetailsImpl
import com.gradleKotlin.todo.authorization.dto.LoginDto
import com.gradleKotlin.todo.authorization.dto.SignUpDto
import com.gradleKotlin.todo.authorization.services.AuthServices
import com.gradleKotlin.todo.entities.User
import com.gradleKotlin.todo.services.UserServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000", "http://127.0.0.1:5500"])
@RestController
@RequestMapping("/api/auth")
class AuthController {

    @Autowired
    private lateinit var userService: UserServices

    @Autowired
    private lateinit var authServices: AuthServices

    @Autowired
    private lateinit var jwtUtils : JwtUtils

    @Autowired
    private lateinit var authenticationManager : AuthenticationManager

    @PostMapping("/signup")
    fun signup(@RequestBody signUpDto: SignUpDto): User {
        return authServices.signUp(signUpDto)
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest : LoginDto): ResponseEntity<Any> {
        val authentication: Authentication = authenticationManager
            .authenticate(UsernamePasswordAuthenticationToken(loginRequest.email, loginRequest.password))

        SecurityContextHolder.getContext().authentication = authentication
        val userDetails = authentication.principal as UserDetailsImpl
        val jwtToken: String = jwtUtils.generateJwtToken(userDetails)
        val user = userService.findUserByEmail(
            loginRequest.email.toString()
        )
        user?.token = jwtToken
        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwtToken).body(user)
    }
}