package com.gradleKotlin.todo.authorization.config.services

import com.fasterxml.jackson.annotation.JsonIgnore
import com.gradleKotlin.todo.entities.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

class UserDetailsImpl(
    val id: Long,
    val email: String,
    @field:JsonIgnore private val password: String,
    authorities: Collection<GrantedAuthority>
) : UserDetails {

    private val authorities: Collection<GrantedAuthority>

    init {
        this.authorities = authorities
    }

    override fun getAuthorities(): Collection<GrantedAuthority> {
        return authorities
    }

    override fun getPassword(): String {
        TODO("Not yet implemented")
    }

    override fun getUsername(): String {
        TODO("Not yet implemented")
    }

    private val isAccountNonExpired: Boolean = true
    override fun isAccountNonExpired(): Boolean {
        return true
    }

    private val isAccountNonLocked: Boolean = true
    override fun isAccountNonLocked(): Boolean {
        return true
    }

    private val isCredentialsNonExpired: Boolean = true
    override fun isCredentialsNonExpired(): Boolean {
        return true
    }

    private val isEnabled: Boolean = true
    override fun isEnabled(): Boolean {
        return true
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val user = o as UserDetailsImpl
        return id == user.id
    }

    companion object {
        private const val serialVersionUID = 1L
        fun build(user: User): UserDetailsImpl {
            val authorities: List<GrantedAuthority> = user.role!!.stream()
                .map { role -> SimpleGrantedAuthority(role.role.toString()) }
                .collect(Collectors.toList())
            return UserDetailsImpl(
                user.id,
                user.email.toString(),
                user.password.toString(),
                authorities
            )
        }
    }
}