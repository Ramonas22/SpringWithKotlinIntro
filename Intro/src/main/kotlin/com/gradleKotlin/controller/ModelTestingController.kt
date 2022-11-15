package com.gradleKotlin.controller

import com.gradleKotlin.model.TestModel
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000","http://127.0.0.1:3000"])
@RestController
@RequestMapping("/testingModel")
class ModelTestingController {

    @PostMapping("/model")
    fun testModel(@RequestBody testModel : TestModel): TestModel{
        println("${testModel.title} ${testModel.content}")
        return testModel
    }
}