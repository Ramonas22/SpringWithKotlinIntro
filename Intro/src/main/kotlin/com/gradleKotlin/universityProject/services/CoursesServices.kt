package com.gradleKotlin.universityProject.services

import com.gradleKotlin.universityProject.dto.CourseDto
import com.gradleKotlin.universityProject.mappers.CourseMapper
import com.gradleKotlin.universityProject.models.Course
import com.gradleKotlin.universityProject.repositories.CourseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CoursesServices {

    @Autowired
    private lateinit var mapper : CourseMapper

    @Autowired
    private lateinit var repo: CourseRepository

    fun addCourse(courseDto : CourseDto?) : CourseDto?{
        return if(courseDto != null){
            mapper.toCourseDto(repo.save(mapper.toCourse(courseDto)!!))
        }else{
            null
        }
    }
    fun getCourseById(id : Long): CourseDto?{
        return mapper.toCourseDto(repo.findByIdOrNull(id))
    }
    fun getAllCourses(): MutableList<CourseDto>?{
        return mapper.toDtoCourses(repo.findAll() as MutableList<Course>)
    }
    fun updateCourse(id: Long, courseDto: CourseDto?): CourseDto?{
       return if(repo.existsById(id)){
           mapper.toCourseDto(repo.save(mapper.toCourse(courseDto)!!))
        }else{
            null
        }
    }
    fun deleteCourseById(id : Long) :String{
        return if (repo.existsById(id)){
            repo.deleteById(id)
            "Successfully deleted course with id ${id}"
        }else{
            "Failed to found course by id"
        }
    }
}