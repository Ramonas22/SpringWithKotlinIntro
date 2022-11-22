package com.gradleKotlin.todo.mappers

import com.gradleKotlin.todo.dto.UserDto
import com.gradleKotlin.todo.entities.User1
import org.springframework.stereotype.Service

@Service
class UserMapper {

    fun toUserDto(user1: User1?): UserDto? {
        return if(user1 != null ){
             UserDto(user1.id, user1.name, user1.surname, user1.email)
        }else{
             null
        }
    }

    fun toUser(user: UserDto?): User1? {
        return  if(user != null){
            user.id?.let { User1(it, user.name, user.surname, user.email) }
        }else {
             null
        }
    }

    fun toUsersDto(user1s: MutableList<User1>?): MutableIterable<UserDto>?{
        val usersDto : MutableList<UserDto> = arrayListOf()
        return if(user1s != null) {
            user1s.forEach {
                toUserDto(it)?.let { it1 -> usersDto.add(it1) }
            }
             usersDto
        }else{
            null
        }
    }
}