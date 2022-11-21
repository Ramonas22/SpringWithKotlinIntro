package com.gradleKotlin.universityProject.mappers

import com.gradleKotlin.universityProject.dto.UniversityDto
import com.gradleKotlin.universityProject.models.University
import org.springframework.stereotype.Service

@Service
class UniversityMapper {

    fun toDto(entity: University?): UniversityDto? {
        return if (entity != null) {
            UniversityDto(entity.id, entity.name.toString(), entity.address.toString(), entity.rating, entity.foundationYear)
        } else {
            null
        }
    }

    fun toUniversity(dto: UniversityDto?): University? {
        return if (dto != null) {
            University(dto.id, dto.name.toString(), dto.address.toString(), dto.rating, dto.foundationYear)
        } else {
            null
        }
    }

    fun toDtoUniversities(entities: MutableList<University>): MutableList<UniversityDto>? {
        val dtoUniversities: MutableList<UniversityDto> = arrayListOf()
        for( i in 0 until entities.size){
            dtoUniversities.add(toDto(entities[i])!!)
        }
        return dtoUniversities
    }
}