package com.gradleKotlin.universityProject.repositories

import com.gradleKotlin.universityProject.models.Course
import org.springframework.data.repository.CrudRepository

interface CourseRepository : CrudRepository<Course , Long> {
}