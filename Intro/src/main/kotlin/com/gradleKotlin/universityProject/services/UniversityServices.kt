package com.gradleKotlin.universityProject.services

import com.gradleKotlin.universityProject.models.University
import com.gradleKotlin.universityProject.repositories.UniversityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UniversityServices {

    @Autowired
    private lateinit var universityRepo: UniversityRepository

    fun addUniversity(university: University): University {
        return universityRepo.save(university)
    }

    fun getUniversityById(id: Long): University? {
        return universityRepo.findById(id).orElse(null)
    }

    fun getAllUniversities(): MutableIterable<University>? {
        return universityRepo.findAll()
    }

    fun updateUniversity(university: University): University? {
        if (universityRepo.existsById(university.id)) {
            universityRepo.save(university)
            return university
        } else {
            print("University with provided id does not exist")
            return null
        }
    }

    fun removeUniversity(id: Long) {
        if(universityRepo.existsById(id)){
            universityRepo.deleteById(id)
            print("Success")
        }else{
            print("Failed to find university with provided id")
        }
    }
}