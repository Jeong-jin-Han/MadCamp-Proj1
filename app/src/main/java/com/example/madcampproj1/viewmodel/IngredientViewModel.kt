package com.example.madcampproj1.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.madcampproj1.model.Ingredient
import com.example.madcampproj1.model.IngredientWithDetails
import com.example.madcampproj1.utils.loadIngredientsFromAssets
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class IngredientViewModel : ViewModel() {

    private val _ingredientList = MutableStateFlow<List<Ingredient>>(emptyList())
    val ingredientList: StateFlow<List<Ingredient>> = _ingredientList

    private val _selectedIngredients = MutableStateFlow<List<IngredientWithDetails>>(emptyList())
    val selectedIngredients: StateFlow<List<IngredientWithDetails>> = _selectedIngredients

    fun loadIngredients(context: Context) {
        viewModelScope.launch {
            _ingredientList.value = loadIngredientsFromAssets(context)
        }
    }

    fun addToCart(ingredient: Ingredient, expiration: String, quantity: Int) {
        val newItem = IngredientWithDetails(ingredient.name, expiration, quantity)
        _selectedIngredients.value = _selectedIngredients.value + newItem
    }
}
