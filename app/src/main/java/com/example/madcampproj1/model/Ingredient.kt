package com.example.madcampproj1.model

data class Ingredient(
    val name: String,
    val category: String,
    val storage: String,
    var isChecked: Boolean = false,
    var expiry: String? = null,
    var count: Int = 1
)