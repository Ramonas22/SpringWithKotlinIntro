package com.gradleKotlin.universityProject.repositories

import com.gradleKotlin.universityProject.models.Student
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Long> {
    @Query("select s from Student s join s.universities us where us.id = :universityId")
    fun findAllByUniversityId(@Param("universityId") universityId: Long): MutableList<Student>
    //fun findAllByUniversityId(universityId: Long) : MutableList<Student>
}