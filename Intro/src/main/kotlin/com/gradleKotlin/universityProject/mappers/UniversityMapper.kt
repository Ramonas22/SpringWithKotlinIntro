package com.gradleKotlin.universityProject.mappers

import com.gradleKotlin.universityProject.dto.UniversityDto
import com.gradleKotlin.universityProject.models.University
import org.springframework.stereotype.Service

@Service
class UniversityMapper {

    fun toDto(entity: University): UniversityDto {
        return UniversityDto(entity.id, entity.name.toString(), entity.address, entity.rating, entity.foundationYear, entity.email)
    }

    fun toUniversity(dto: UniversityDto): University {
        return    University(dto.id, dto.name.toString(), dto.address, dto.rating, dto.foundationYear, dto.email)
    }

    fun toDtoUniversities(entities: MutableList<University>): MutableList<UniversityDto>? {
        val dtoUniversities: MutableList<UniversityDto> = arrayListOf()
        for( i in 0 until entities.size){
            dtoUniversities.add(toDto(entities[i]))
        }
        return dtoUniversities
    }
}