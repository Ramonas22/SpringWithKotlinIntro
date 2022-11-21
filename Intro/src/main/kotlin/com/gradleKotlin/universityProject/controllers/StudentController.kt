package com.gradleKotlin.universityProject.controllers

import com.gradleKotlin.universityProject.mappers.StudentMapper
import com.gradleKotlin.universityProject.services.StudentServices
import com.gradleKotlin.universityProject.models.Student
import com.gradleKotlin.universityProject.dto.StudentDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*


@CrossOrigin(origins = ["http://localhost:3000", "http://127.0.0.1:3000"])
@RestController
@RequestMapping("/university/student")
class StudentController {

    @Autowired
    private lateinit var studentService: StudentServices

    @Autowired
    private lateinit var mapper : StudentMapper

    @GetMapping("/get-Students")
    fun getStudents() : MutableList<StudentDto>? {
        return mapper.toDtoStudents(studentService.getAllStudents() as MutableList<Student>)
    }

    @GetMapping("/get-Student/{id}")
    fun getStudent(@PathVariable id : Long) : StudentDto? {
        return mapper.toDto(studentService.getByIdStudents(id))
    }

    @PostMapping("/add-Student")
    fun postStudent(@RequestBody student: StudentDto?): StudentDto? {
        mapper.toStudent(student)?.let { studentService.insertStudentIntoDb(it) }
        return student
    }

    @PutMapping("/update-Student")
    fun updateStudent(@RequestBody student: StudentDto?) : StudentDto?{
        mapper.toStudent(student)?.let { studentService.updateStudent(it) }
        return  student
    }

    @DeleteMapping("/delete-Student/{id}")
    fun deleteStudent(@PathVariable id: Long): String{
        return studentService.deleteStudentById(id)
    }
}