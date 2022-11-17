package com.gradleKotlin.intro.service

import com.gradleKotlin.intro.model.Temperature
import org.springframework.stereotype.Service

@Service
class TemperatureConverterService {
    fun convertCelsiusToFahrenheit(temperature: Double): Double {
        return (Math.round((temperature * 9 / 5 + 32)*10/10).toDouble())
    }

    fun convertFahrenheitToCelsius(temperature: Double): Double {
        return (Math.round(((temperature-32) * 0.5556)*10)/10).toDouble()
    }

    fun calculateMissing(tempBody: Temperature): Temperature {
        if(tempBody.celsius.equals(null)){
            tempBody.celsius = convertFahrenheitToCelsius(tempBody.fahrenheit)
            println("Calculated celsius")
        }else {
            tempBody.celsius = convertCelsiusToFahrenheit(tempBody.fahrenheit)
            print("calculated fahrenheit")
        }
        return tempBody
    }

}