package com.gradleKotlin.intro.service

import com.gradleKotlin.intro.model.TestModel
import org.springframework.stereotype.Service

@Service
class TestModelServices {
    fun returnCapitalTitle(value : TestModel) : TestModel {
        value.title = value.title?.toUpperCase()
        return value
    }
    fun countAssignees(value: MutableList<String>) : Int{
        return value.size
    }
}