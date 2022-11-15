package com.gradleKotlin.controller

import com.gradleKotlin.model.TestModel
import com.gradleKotlin.service.MathService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.properties.bind.DefaultValue
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["http://localhost:3000","http://127.0.0.1:3000"])
@RestController
class TestGradle {

    @Autowired
    private lateinit var mathService : MathService

    @GetMapping("/testGet")
    fun gradleGet(): String {
        mathService.testService()
        return "This is what u get from kotlin gradle"
    }

    @PostMapping("/testPost")
    fun gradlePost(@RequestParam(required = false) @DefaultValue(value = ["Nothing"]) arg: String): String {
        return "Here is what u get when u post kotlin gradle ${arg}"
    }

    @PutMapping("/testPut")
    fun gradlePut(@RequestParam(required = false) @DefaultValue(value = ["nothing"]) arg: String): String {
        return "Here is what u get when u put kotlin gradle ${arg}"
    }

    @DeleteMapping("/testDelete")
    fun gradleDelete(@RequestParam(required = false) @DefaultValue(value = ["nothing was passed"]) arg: String): String {
        return "This is waht you tryed to delete using kotlin gradle ${arg}"
    }


    @GetMapping("/testQueryParam")
    fun gradleQueryParam(@RequestParam(name = "data") data: String,@RequestParam(name = "stringData") stringData : String) : String{
        return "${stringData} ${data}"
    }

    @GetMapping("/sumOfTwo")
    fun gradleReturnSum(@RequestParam(name = "num1") num1: Int,@RequestParam(name = "num2") num2: Int ) : String{
        return mathService.returnSum(num1.toDouble(), num2.toDouble()).toString()
    }

    @GetMapping("/doMath")
    fun gradleReturnMath(@RequestParam(name = "num1") num1: Double,@RequestParam(name = "num2") num2: Double, @RequestParam(name = "sign") sign: String): String{
        when (sign) {
            "+" -> {
                return "${num1 + num2}"
            }
            "-" -> {
                return "${num1 - num2}"
            }
            "/" -> {
                return "${num1 / num2}"
            }
            "*" -> {
                return "${num1 * num2}"
            }
            else -> {
                return sign
            }
        }
    }

    @GetMapping("/math/{num1}/{num2}/{sign}")
    fun pathVariable(@PathVariable(name = "num1") num1: Double,@PathVariable(name = "num2") num2: Double, @PathVariable(name = "sign") sign: String): String{
        when (sign) {
            "+" -> {
                return "${num1 + num2}"
            }
            "-" -> {
                return "${num1 - num2}"
            }
            "/" -> {
                return "${num1 / num2}"
            }
            "*" -> {
                return "${num1 * num2}"
            }
            else -> {
                return sign
            }
        }
    }
}