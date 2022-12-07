package com.gradleKotlin.todo.authorization.config.jwt

import com.gradleKotlin.todo.authorization.config.services.UserDetailsImpl
import io.jsonwebtoken.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtils {
    @Value("\${codeAcademy.app.jwtSecret}")
    private val jwtSecret: String? = null

    @Value("\${codeAcademy.app.jwtExpirationMs}")
    private val jwtExpirationMs = 0

    fun generateJwtToken(userPrincipal: UserDetailsImpl): String {
        return generateTokenFromUsername(userPrincipal.email)
    }

    fun getUserNameFromJwtToken(token: String?): String {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body.subject
    }

    fun validateJwtToken(authToken: String?): Boolean {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken)
            return true
        } catch (e: SignatureException) {
            logger.error("Invalid JWT signature: {}", e.message)
        } catch (e: MalformedJwtException) {
            logger.error("Invalid JWT token: {}", e.message)
        } catch (e: ExpiredJwtException) {
            logger.error("JWT token is expired: {}", e.message)
        } catch (e: UnsupportedJwtException) {
            logger.error("JWT token is unsupported: {}", e.message)
        } catch (e: IllegalArgumentException) {
            logger.error("JWT claims string is empty: {}", e.message)
        }
        return false
    }

    fun generateTokenFromUsername(username: String?): String {
        return Jwts.builder()
            .claim("Raktas", "reiksme")
            .setSubject(username)
            .setIssuedAt(Date())
            .setExpiration(Date(Date().time + jwtExpirationMs))
            .signWith(SignatureAlgorithm.HS512, jwtSecret)
            .compact()
    }

    companion object {
        private val logger = LoggerFactory.getLogger(JwtUtils::class.java)
    }
}