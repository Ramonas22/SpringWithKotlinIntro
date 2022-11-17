package com.gradleKotlin.service

import com.gradleKotlin.model.Student
import com.gradleKotlin.repository.StudentRepository
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

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

    fun getByIdStudents(id: Long): Optional<Student> {
        return studentRepo.findById(id)
    }

    fun updateStudent(student: Student): Student {
        return studentRepo.save(student)
    }

    fun deleteStudentById(id: Long): String {
        if(studentRepo.existsById(id)){
            studentRepo.deleteById(id)
            return "${id} deleted"
        }else{
            return "${id} not found in db"
        }
    }
}