package com.example.madcampproj1.model

data class RecipeWithSteps(
    val name: String,
    val image: String,
    val ingredients: List<String>,
    val steps: List<String>
)