package com.gradleKotlin.intro.controller

import com.gradleKotlin.intro.model.IdentityCode
import com.gradleKotlin.intro.model.TestModel
import com.gradleKotlin.intro.service.IdentityCodeService
import com.gradleKotlin.intro.service.TestModelServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000","http://127.0.0.1:3000"])
@RestController
@RequestMapping("/testingModel")
class ModelTestingController {
    @Autowired
    private lateinit var modelServices: TestModelServices
    @Autowired
    private lateinit var identityCodeService : IdentityCodeService

    @PostMapping("/postModel")
    fun testModel(@RequestBody testModel : TestModel): TestModel {
        println("${testModel.title} ${testModel.content}")
        return testModel
    }
    @PostMapping("/postModelCapitals")
    fun testModelCapitals(@RequestBody testModel : TestModel): TestModel {
        println("${testModel.title} ${testModel.content}")
        return modelServices.returnCapitalTitle(testModel)
    }

    @PostMapping("/countAssignees")
    fun countAssignees(@RequestBody testModel : TestModel): TestModel {
        println("${testModel.title} ${testModel.content}")
        testModel.counter = modelServices.countAssignees(testModel.assignedNames!!)
        return modelServices.returnCapitalTitle(testModel)
    }
    @PostMapping("/checkId")
    fun checkId(@RequestBody idData : IdentityCode) : Boolean{
        return identityCodeService.checkIfValid(idData)
    }
}