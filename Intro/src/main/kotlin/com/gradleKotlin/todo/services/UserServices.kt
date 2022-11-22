package com.gradleKotlin.todo.services

import com.gradleKotlin.todo.dto.UserDto
import com.gradleKotlin.todo.mappers.UserMapper
import com.gradleKotlin.todo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserServices {
    @Autowired
    private lateinit var mapper: UserMapper

    @Autowired
    private lateinit var userRepository: UserRepository

    fun addUser(userDto: UserDto?): UserDto? {
        return if (userDto != null) {
            mapper.toUserDto(mapper.toUser(userDto)?.let { userRepository.save(it) })
        } else {
            print("User is null")
            null
        }
    }

    fun findUserById(id : Long):UserDto? {
        return mapper.toUserDto(userRepository.findByIdOrNull(id))
    }

    fun getAllUsers(): MutableList<UserDto>? {
        return mapper.toUsersDto(userRepository.findAll().toMutableList()) as MutableList<UserDto>?
    }

    fun updateUser(userDto : UserDto) : UserDto?{
        return if(userRepository.existsById(userDto.id)){
            mapper.toUserDto(mapper.toUser(userDto)?.let{ userRepository.save(it)})
        }else{
            print("User with provided id does not exist")
            null
        }
    }

    fun deleteUserById(id : Long) {
        if(userRepository.existsById(id)){
            print("Success")
            userRepository.deleteById(id)
        }else{
            print("User with provided id was not found")
        }
    }
}