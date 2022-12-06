package com.gradleKotlin.todo.mappers

import com.gradleKotlin.todo.dto.UserDto
import com.gradleKotlin.todo.entities.TodoApp
import com.gradleKotlin.todo.entities.User
import com.gradleKotlin.todo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserMapper {

    @Autowired
    private lateinit var userRepo : UserRepository

    fun toUserDto(user: User): UserDto? {
        return run {
            val todosIdList : MutableList<Long> = arrayListOf()
            if(!user.userTodos.isNullOrEmpty()){
                user.userTodos!!.forEach { grabId -> todosIdList.add(grabId.id) }
            }
            UserDto(user.id, user.name, user.surname, user.email, todosIdList)
        }
    }

    fun toUser(user: UserDto?): User? {
        return  if(user != null){
            val todoList : MutableList<TodoApp> = arrayListOf()
            if(user.todosList?.isNotEmpty() == true){
                todoList.addAll(userRepo.findAllById(user.todosList) as MutableList<TodoApp>)
            }
            User(user.id, user.name, user.surname, user.email,null , todoList)
        }else {
             null
        }
    }

    fun toUsersDto(users: MutableList<User>?): MutableIterable<UserDto>?{
        val usersDto : MutableList<UserDto> = arrayListOf()
        return if(users != null) {
            users.forEach {
                toUserDto(it)?.let { it1 -> usersDto.add(it1) }
            }
             usersDto
        }else{
            null
        }
    }
}