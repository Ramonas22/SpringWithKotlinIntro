package com.gradleKotlin.intro.model

import lombok.Data


@Data
data class TestModel(
    var id : Long,
    var title: String? = null,
    var content: String? = null,
    var assignedNames: MutableList<String>? = arrayListOf(),
    var counter: Int? = 0

)
