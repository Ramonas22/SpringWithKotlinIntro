package com.gradleKotlin.universityProject.mappers

import com.gradleKotlin.universityProject.dto.CourseDto
import com.gradleKotlin.universityProject.models.Course
import com.gradleKotlin.universityProject.models.Student
import org.springframework.stereotype.Service

@Service
class CourseMapper {

    fun toCourseDto(course: Course?): CourseDto? {
        return if (course != null) {
            val studentsIds: MutableList<Long> = arrayListOf()
            if (!course.studentsEnrolled.isNullOrEmpty())
                course.studentsEnrolled?.forEach { student ->
                    studentsIds.add(student.id)
                }
            CourseDto(course.id, course.title, course.credits, studentsIds)
        } else {
            null
        }
    }

    fun toCourse(courseDto: CourseDto?): Course? {
        return if (courseDto != null) {
            val students: MutableList<Student> = arrayListOf()
            if (!courseDto.studentsEnrolled.isNullOrEmpty()) {
                courseDto.studentsEnrolled.forEach { id ->
                    students.add(Student(id))
                }
            }
            Course(courseDto.id, courseDto.title, courseDto.credits, students)
        } else {
            null
        }
    }

    fun toDtoCourses(courses: MutableList<Course>?): MutableList<CourseDto>?{
        val coursesDto : MutableList<CourseDto> = arrayListOf()
        return if(courses != null) {
            courses.forEach { course ->
                toCourseDto(course)?.let { coursesDto.add(it) }
            }
            return coursesDto
        }else{
            null
        }
        }
}