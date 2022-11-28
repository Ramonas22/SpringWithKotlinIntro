package com.gradleKotlin.universityProject.mappers

import com.gradleKotlin.universityProject.models.Student
import com.gradleKotlin.universityProject.dto.StudentDto
import com.gradleKotlin.universityProject.models.University
import com.gradleKotlin.universityProject.repositories.UniversityRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class StudentMapper {


    fun toDto(entity: Student?): StudentDto? {
        return if (entity != null) {
            val universitiesIds: MutableList<Long> = arrayListOf()
            if(!entity.universities.isNullOrEmpty())
            {
                entity.universities!!.forEach {
                    university -> universitiesIds.add(university.id)
                }
            }
            StudentDto(entity.id, entity.firstName.toString(), entity.lastName.toString(), entity.personalCode.toString(), entity.course.toString(),universitiesIds)
        } else {
            null
        }
    }

    fun toStudent(dto: StudentDto): Student {
            val universities : MutableList<University> = arrayListOf()
                dto.universitiesId?.forEach {
                    id ->
                    universities.add(University(id,null,null,null,null,null,null))
                }
        return Student(dto.id, dto.firstName.toString(), dto.lastName.toString(), dto.personalCode.toString(), dto.course.toString(),universities)
    }

    fun toDtoStudents(entities: MutableList<Student>?): MutableList<StudentDto>? {
        val dtoStudents: MutableList<StudentDto> = arrayListOf()
        if (entities != null) {
            for( i in 0 until entities.size){
                dtoStudents.add(toDto(entities[i])!!)
            }
        }
        return dtoStudents
    }
}
