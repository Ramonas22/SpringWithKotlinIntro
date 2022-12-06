package com.gradleKotlin.todo.authorization

import com.gradleKotlin.todo.authorization.entity.Role
import com.gradleKotlin.todo.authorization.roles.RolesEnum
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApplicationInit : ApplicationRunner{

    @Autowired
    private lateinit var repo : RolesRepository

    override fun run(args: ApplicationArguments?) {
        if(repo.findByRole(RolesEnum.ROLE_ADMIN) == null){
            repo.save(Role(1,RolesEnum.ROLE_ADMIN))
        }
        if(repo.findByRole(RolesEnum.ROLE_USER) == null){
            repo.save(Role(2,RolesEnum.ROLE_USER))
        }

    }
}