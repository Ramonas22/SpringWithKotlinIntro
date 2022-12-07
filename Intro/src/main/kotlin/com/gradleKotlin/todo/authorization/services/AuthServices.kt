package com.gradleKotlin.todo.authorization.services

import com.gradleKotlin.todo.authorization.RolesRepository
import com.gradleKotlin.todo.authorization.dto.SignUpDto
import com.gradleKotlin.todo.authorization.entity.Role
import com.gradleKotlin.todo.authorization.roles.RolesEnum
import com.gradleKotlin.todo.entities.User
import com.gradleKotlin.todo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.lang.Exception

@Service
class AuthServices {

    @Autowired
    private lateinit var repo: UserRepository

    @Autowired
    private lateinit var rolesRepositoryRepo : RolesRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    fun signUp(signUpDto: SignUpDto) : User {
        if(repo.findByEmail(signUpDto.email!!).isPresent){
            throw Exception("Email ${signUpDto.email} already in use")
        }
        if(signUpDto.password != signUpDto.repeatPassword){
            throw Exception("Passwords do now match")
        }
        val user : User = User()

        user.email = signUpDto.email
        user.password =  passwordEncoder.encode(signUpDto.password)
        user.role = listOf(rolesRepositoryRepo.findByRole(RolesEnum.ROLE_USER)) as MutableList<Role>

        return repo.save(user)

    }

}