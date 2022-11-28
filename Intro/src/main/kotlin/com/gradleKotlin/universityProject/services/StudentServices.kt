package com.gradleKotlin.universityProject.services

import com.gradleKotlin.universityProject.dto.StudentDto
import com.gradleKotlin.universityProject.mappers.StudentMapper
import com.gradleKotlin.universityProject.models.Student
import com.gradleKotlin.universityProject.repositories.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServices {

    @Autowired
    private lateinit var studentRepo : StudentRepository

    @Autowired
    private lateinit var mapper : StudentMapper

    fun insertStudentIntoDb(student : StudentDto?) : StudentDto?{
      return if(student != null ){
          mapper.toDto(studentRepo.save(mapper.toStudent(student)))
      }else{
          null
      }
    }

    fun getAllStudents(): MutableList<StudentDto>? {
        return mapper.toDtoStudents(studentRepo.findAll() as MutableList<Student>)
    }

    fun getByIdStudents(id: Long): StudentDto? {
        return mapper.toDto(studentRepo.findById(id).orElse(null))
    }

    fun updateStudent(id: Long, student: StudentDto): StudentDto? {
        return if(studentRepo.existsById(id)){
             mapper.toDto(studentRepo.save(mapper.toStudent(student)))
        }else{
             null
        }
    }

    fun deleteStudentById(id: Long): String {
        return if(studentRepo.existsById(id)){
            studentRepo.deleteById(id)
            "${id} deleted"
        }else{
            "${id} not found in db"
        }
    }

    fun findStudentsByUniversityId(id: Long): MutableList<StudentDto>? {
        return mapper.toDtoStudents(studentRepo.findAllByUniversityId(id))
    }
}