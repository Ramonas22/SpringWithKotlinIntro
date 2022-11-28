package com.gradleKotlin.universityProject.services

import com.gradleKotlin.universityProject.dto.UniversityDto
import com.gradleKotlin.universityProject.mappers.UniversityMapper
import com.gradleKotlin.universityProject.models.University
import com.gradleKotlin.universityProject.repositories.UniversityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UniversityServices {

    @Autowired
    private lateinit var universityRepo: UniversityRepository

    @Autowired
    private lateinit var mapper: UniversityMapper

    fun addUniversity(university: UniversityDto): UniversityDto {
        return mapper.toDto(universityRepo.save(mapper.toUniversity(university)))
    }

    fun getUniversityById(id: Long): UniversityDto? {
        return mapper.toDto(universityRepo.findById(id).orElse(null))
    }

    fun getAllUniversities(): MutableIterable<UniversityDto>? {
        return mapper.toDtoUniversities(universityRepo.findAll() as MutableList<University>)
    }

    fun updateUniversity(id: Long, university: UniversityDto): UniversityDto? {
        return if (universityRepo.existsById(id)) {
            universityRepo.save(mapper.toUniversity(university))
            university
        } else {
            print("University with provided id does not exist")
            null
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