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

    @PostMapping("/addUniversity")
    fun addUniversity(@Valid @RequestBody university: UniversityDto): UniversityDto {
        return universityServices.addUniversity(university)
    }

    @GetMapping("/find-University-By-Id/{id}")
    fun findUniversityById(@PathVariable id: Long): UniversityDto? {
        return universityServices.getUniversityById(id)
    }

    @GetMapping("/get-All-Universities")
    fun getAllUniversities(): MutableList<UniversityDto>? {
        return universityServices.getAllUniversities() as MutableList<UniversityDto>?
    }

    @PutMapping("update-University-Info/{id}")
    fun updateUniversityInfo(@PathVariable id: Long,  @RequestBody university: UniversityDto): UniversityDto? {
        return universityServices.updateUniversity(id, university)
    }

    @DeleteMapping("delete-University-By-Id/{id}")
    fun deleteUniversityById(@PathVariable id: Long) {
        universityServices.removeUniversity(id)
    }

}