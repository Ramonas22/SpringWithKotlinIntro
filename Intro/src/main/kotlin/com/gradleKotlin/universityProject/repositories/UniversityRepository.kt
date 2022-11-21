package com.gradleKotlin.universityProject.repositories

import com.gradleKotlin.universityProject.models.University
import org.springframework.data.repository.CrudRepository

interface UniversityRepository : CrudRepository<University, Long> {
}