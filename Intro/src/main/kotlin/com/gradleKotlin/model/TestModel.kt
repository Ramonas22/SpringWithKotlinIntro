package com.gradleKotlin.model

import lombok.Data


@Data
data class TestModel(
    var title: String? = null,
    var content: String? = null,
    var assignedNames: MutableList<String>? = arrayListOf(),
    var counter: Int? = 0

)
