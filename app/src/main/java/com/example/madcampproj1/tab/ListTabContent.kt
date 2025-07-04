package com.example.madcampproj1.tab

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.madcampproj1.model.Ingredient
import com.example.madcampproj1.viewmodel.IngredientViewModel
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.rememberDatePickerState
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListTabContent(
    ingredientViewModel: IngredientViewModel = viewModel()
) {
    val context = LocalContext.current
    val ingredientList by ingredientViewModel.ingredientList.collectAsState()
    val selectedIngredients by ingredientViewModel.selectedIngredients.collectAsState()

    var searchQuery by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    var currentIngredient by remember { mutableStateOf<Ingredient?>(null) }
    var expirationInput by remember { mutableStateOf("") }
    var quantityInput by remember { mutableStateOf("") }
    var showDatePicker by remember { mutableStateOf(false) }

    val dateFormatter = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }

    LaunchedEffect(Unit) {
        ingredientViewModel.loadIngredients(context)
    }

    val filteredList = if (searchQuery.isNotEmpty()) {
        ingredientList.filter { it.name.startsWith(searchQuery) }
    } else emptyList()

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("식재료 검색") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(filteredList) { ingredient ->
                Text(
                    text = ingredient.name,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            currentIngredient = ingredient
                            expirationInput = ""
                            quantityInput = ""
                            showDialog = true
                        }
                        .padding(8.dp)
                )
                Divider()
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("🛒 장바구니", style = MaterialTheme.typography.titleLarge)

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            items(selectedIngredients) { item ->
                Text(text = "• ${item.name} | 유통기한: ${item.expirationDate} | 수량: ${item.quantity}개")
            }
        }
    }

    // ✅ 다이얼로그
    if (showDialog && currentIngredient != null) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("${currentIngredient!!.name} 추가") },
            text = {
                Column {
                    OutlinedTextField(
                        value = expirationInput,
                        onValueChange = {},
                        label = { Text("유통기한 (클릭해서 선택)") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { showDatePicker = true },
                        readOnly = true,
                        trailingIcon = {
                            IconButton(onClick = { showDatePicker = true }) {
                                Icon(Icons.Default.DateRange, contentDescription = "날짜 선택")
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(
                        value = quantityInput,
                        onValueChange = { quantityInput = it.filter { c -> c.isDigit() } },
                        label = { Text("수량") },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            },
            confirmButton = {
                Button(onClick = {
                    if (expirationInput.isNotBlank() && quantityInput.isNotBlank()) {
                        ingredientViewModel.addToCart(currentIngredient!!, expirationInput, quantityInput.toInt())
                        showDialog = false
                    }
                }) {
                    Text("추가")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showDialog = false }) {
                    Text("취소")
                }
            }
        )
    }

    // ✅ 달력 띄우기
    if (showDatePicker) {
        val datePickerState = rememberDatePickerState()

        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(onClick = {
                    datePickerState.selectedDateMillis?.let { millis ->
                        expirationInput = dateFormatter.format(Date(millis))
                    }
                    showDatePicker = false
                }) {
                    Text("확인")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("취소")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}

