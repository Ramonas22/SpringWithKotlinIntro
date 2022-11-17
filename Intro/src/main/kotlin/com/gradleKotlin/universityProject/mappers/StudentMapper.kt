package com.gradleKotlin.universityProject.mappers

import com.gradleKotlin.universityProject.models.Student
import com.gradleKotlin.universityProject.models.StudentDto
import org.springframework.stereotype.Service

@Service
class StudentMapper {

    fun toDto(entity: Student?): StudentDto? {
        return if (entity != null) {
            StudentDto(entity.id, entity.firstName.toString(), entity.lastName.toString(), entity.personalCode.toString(), entity.course.toString())
        } else {
            null
        }
    }

    fun toStudent(dto: StudentDto?): Student? {
        return if (dto != null) {
            Student(dto.id, dto.firstName.toString(), dto.lastName.toString(), dto.personalCode.toString(), dto.course.toString())
        } else {
            null
        }
    }

    fun toDtoStudents(entities: MutableList<Student>): MutableList<StudentDto>? {
        val dtoStudents: MutableList<StudentDto> = arrayListOf()
        for( i in 0 until entities.size){
            dtoStudents.add(toDto(entities[i])!!)
        }
        return dtoStudents
    }
}
