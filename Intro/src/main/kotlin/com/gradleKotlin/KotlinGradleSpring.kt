package com.gradleKotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinGradleSpring

fun main(args: Array<String>) {
	runApplication<KotlinGradleSpring>(*args)
}
