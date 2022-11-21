package com.gradleKotlin.universityProject.repositories

import com.gradleKotlin.universityProject.models.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Long> {
}