package com.gradleKotlin.universityProject.controllers

import com.gradleKotlin.universityProject.dto.CourseDto
import com.gradleKotlin.universityProject.services.CoursesServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin(origins = ["http://localhost:3000", "http://127.0.0.1:3000"])
@RequestMapping("/course")
class CourseController {

    @Autowired
    private lateinit var service: CoursesServices

    @GetMapping("/get-All-Courses")
    fun getAllCourse(): MutableList<CourseDto>? {
        return service.getAllCourses()
    }

    @GetMapping("/{id}")
    fun getCourseById(@PathVariable id: Long): CourseDto? {
        return service.getCourseById(id)
    }

    @PostMapping("/create")
    fun addCourse(@RequestBody courseDto: CourseDto?): CourseDto? {
        return service.addCourse(courseDto)
    }

    @PutMapping("/update/{id}")
    fun updateCourse(@PathVariable id: Long, @RequestBody courseDto: CourseDto?): CourseDto? {
        return service.updateCourse(id, courseDto)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteCourse(@PathVariable id: Long): String {
        return service.deleteCourseById(id)
    }
}