package com.example.madcampproj1.utils

// JSON 로드 함수
import android.content.Context
import com.example.madcampproj1.model.Ingredient
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

fun loadIngredientsFromAssets(context: Context): List<Ingredient> {
    val jsonString = context.assets.open("ingredients.json")
        .bufferedReader()
        .use { it.readText() }

    val gson = Gson()
    val listType = object : TypeToken<List<Ingredient>>() {}.type
    return gson.fromJson(jsonString, listType)
}