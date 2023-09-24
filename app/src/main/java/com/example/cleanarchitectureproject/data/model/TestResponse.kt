package com.example.cleanarchitectureproject.data.model

data class TestResponse(
    val `data`: List<Data> = emptyList(),
    val message: String = "",
    val status: Int = 0
)

data class Data(
    val content: String = "",
    val examples: List<Example> = emptyList(),
    val questionId: Int = 0,
    val type: String = ""

)

data class Example(
    val content: String = "",
    val exampleId: Int = 0
)