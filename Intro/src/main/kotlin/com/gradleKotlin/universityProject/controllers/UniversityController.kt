package com.gradleKotlin.universityProject.controllers

import com.gradleKotlin.universityProject.dto.UniversityDto
import com.gradleKotlin.universityProject.mappers.UniversityMapper
import com.gradleKotlin.universityProject.models.University
import com.gradleKotlin.universityProject.services.UniversityServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@CrossOrigin(origins = ["http://localhost:3000", "http://127.0.0.1:3000"])
@RestController
@RequestMapping("/university/university")
class UniversityController {
    @Autowired
    private lateinit var universityServices: UniversityServices

    @Autowired
    private lateinit var mapper: UniversityMapper

    @PostMapping("/addUniversity")
    fun addUniversity(@Valid @RequestBody university: UniversityDto): UniversityDto {
        return mapper.toDto(mapper.toUniversity(university).let { universityServices.addUniversity(it) })
    }

    @GetMapping("/find-University-By-Id/{id}")
    fun findUniversityById(@PathVariable id: Long): UniversityDto? {
        return universityServices.getUniversityById(id)?.let { mapper.toDto(it) }
    }

    @GetMapping("/get-All-Universities")
    fun getAllUniversities(): MutableList<UniversityDto>? {
        return mapper.toDtoUniversities(universityServices.getAllUniversities() as MutableList<University>)
    }

    @PutMapping("update-University-Info")
    fun updateUniversityInfo(@RequestBody university: UniversityDto): UniversityDto {
        return mapper.toDto(mapper.toUniversity(university).let { universityServices.updateUniversity(it) }!!)
    }

    @DeleteMapping("delete-University-By-Id/{id}")
    fun deleteUniversityById(@PathVariable id: Long) {
        universityServices.removeUniversity(id)
    }

}