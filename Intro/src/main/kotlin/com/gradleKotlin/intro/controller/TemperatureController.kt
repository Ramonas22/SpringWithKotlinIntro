package com.gradleKotlin.intro.controller

import com.gradleKotlin.intro.model.Temperature
import com.gradleKotlin.intro.service.TemperatureConverterService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:3000","http://127.0.0.1:3000"])
@RestController
@RequestMapping("/temperature")
class TemperatureController {

    @Autowired
    private lateinit var temperatureConverter: TemperatureConverterService

    @GetMapping("/celsius")
    fun celsius(@RequestParam(name = "temp") temp : Double): Double {
        return temperatureConverter.convertCelsiusToFahrenheit(temp)
    }
    @GetMapping("/fahrenheit")
    fun fahrenheit(@RequestParam(name = "temp") temp : Double): Double{
        return  temperatureConverter.convertFahrenheitToCelsius(temp)
    }
    @PostMapping("/combined")
    fun combined(@RequestBody tempBody : Temperature) : Temperature {
        println(tempBody)
        return temperatureConverter.calculateMissing(tempBody)
    }
}