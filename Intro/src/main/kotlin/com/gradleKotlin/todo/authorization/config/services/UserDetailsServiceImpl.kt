package com.gradleKotlin.todo.authorization.config.services

import com.gradleKotlin.todo.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserDetailsServiceImpl : UserDetailsService {
    @Autowired
    private lateinit var userRepository: UserRepository

    @Transactional
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(email: String): UserDetails {
        val user: com.gradleKotlin.todo.entities.User? = userRepository.findByEmail(email)
            .orElseThrow { UsernameNotFoundException("User Not Found with username: $email") }
        return UserDetailsImpl.build(user!!)
    }

}
