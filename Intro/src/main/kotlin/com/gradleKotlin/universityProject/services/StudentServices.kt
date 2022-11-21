package com.gradleKotlin.universityProject.services

import com.gradleKotlin.universityProject.models.Student
import com.gradleKotlin.universityProject.repositories.StudentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StudentServices {

    @Autowired
    private lateinit var studentRepo : StudentRepository

    fun insertStudentIntoDb(student : Student){
        studentRepo.save(student)

    }

    fun getAllStudents(): MutableIterable<Student> {
        return studentRepo.findAll()
    }

    fun getByIdStudents(id: Long): Student? {
        return studentRepo.findById(id).orElse(null)
    }

    fun updateStudent(student: Student): Student? {
        return if(studentRepo.existsById(student.id)){
             studentRepo.save(student)
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
}