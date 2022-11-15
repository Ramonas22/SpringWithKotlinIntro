package com.gradleKotlin.service

import org.springframework.stereotype.Service

@Service
class MathService {

    fun testService() {
        println("I was called")
    }

    fun returnSum(num1: Double, num2: Double): Double {
        return num1 + num2
    }

}