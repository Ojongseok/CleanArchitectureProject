package com.example.cleanarchitectureproject.data.model

data class TestResponse(
    val `data`: List<Data>,
    val message: String,
    val status: Int
)

data class Data(
    val content: String,
    val examples: List<Example>,
    val questionId: Int,
    val type: String
)

data class Example(
    val content: String,
    val exampleId: Int
)