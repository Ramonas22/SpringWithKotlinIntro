package com.gradleKotlin.universityProject.controllers

import com.gradleKotlin.universityProject.services.StudentServices
import com.gradleKotlin.universityProject.models.Student
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@CrossOrigin(origins = ["http://localhost:3000", "http://127.0.0.1:3000"])
@RestController
@RequestMapping("/university")
class StudentController {

    @Autowired
    private lateinit var studentService: StudentServices

    @GetMapping("/get-Students")
    fun getStudents() : MutableIterable<Student> {
        return studentService.getAllStudents()
    }

    @GetMapping("/get-Student/{id}")
    fun getStudent(@PathVariable id : Long) : Optional<Student> {
        return studentService.getByIdStudents(id)
    }

    @PostMapping("/add-Student")
    fun postStudent(@RequestBody student: Student): Student {
        studentService.insertStudentIntoDb(student)
        return student
    }

    @PutMapping("/update-Student")
    fun updateStudent(@RequestBody student: Student) : Student?{
        return studentService.updateStudent(student)
    }

    @DeleteMapping("/delete-Student/{id}")
    fun deleteStudent(@PathVariable id: Long): String{
        return studentService.deleteStudentById(id)
    }
}