package com.gradleKotlin.universityProject.mappers

import com.gradleKotlin.universityProject.dto.UniversityDto
import com.gradleKotlin.universityProject.models.Student
import com.gradleKotlin.universityProject.models.University
import com.gradleKotlin.universityProject.repositories.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UniversityMapper {

    fun toDto(entity: University): UniversityDto {
        val studentIds : MutableList<Long> = arrayListOf()
        if(!entity.students.isNullOrEmpty()){
            entity.students!!.forEach {
                student -> studentIds.add(student.id)
            }
        }
        return UniversityDto(entity.id, entity.name.toString(), entity.address.toString(), entity.rating, entity.foundationYear, entity.email.toString(), studentIds)
    }

    fun toUniversity(dto: UniversityDto): University {
        val students: MutableList<Student> = arrayListOf()
            dto.studentsIds?.forEach {
                id-> students.add(Student(id,null,null, null,null,null))
            }
        return    University(dto.id, dto.name.toString(), dto.address, dto.rating, dto.foundationYear, dto.email, students)
    }

    fun toDtoUniversities(entities: MutableList<University>): MutableList<UniversityDto>? {
        val dtoUniversities: MutableList<UniversityDto> = arrayListOf()
        for( i in 0 until entities.size){
            dtoUniversities.add(toDto(entities[i]))
        }
        return dtoUniversities
    }
}