//package com.example.madcampproj1.tab
//
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
////import androidx.compose.material3.Divider
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//import androidx.compose.material3.HorizontalDivider
//
//import android.content.Context
//import androidx.compose.foundation.BorderStroke
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
////import android.content.Context
//import androidx.compose.runtime.*
//import androidx.compose.ui.platform.LocalContext
//
//import androidx.compose.runtime.saveable.rememberSaveable
//import androidx.compose.foundation.lazy.itemsIndexed
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.shape.RoundedCornerShape
////import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.lazy.LazyColumn
////import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material3.Checkbox
//import androidx.compose.material3.Surface
////import androidx.compose.material3.Text
////import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.graphics.Color
//
////import androidx.compose.ui.Modifier
////import androidx.compose.ui.unit.dp
//
//// 🔽 HorizontalPager 관련
//import androidx.compose.foundation.pager.HorizontalPager
//import androidx.compose.foundation.pager.rememberPagerState
//import androidx.compose.foundation.pager.PagerState
//// LazyRow 및 LazyColumn 관련
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
//import androidx.compose.material3.AlertDialog
//import androidx.compose.material3.Divider
//import androidx.compose.material3.IconButton
//import androidx.compose.material3.OutlinedTextField
//import androidx.compose.material3.TextButton
//import kotlinx.coroutines.launch
//
////data class Ingredient(
////    val name: String,
////    val category: String,
////    val storage: String,
////    var isChecked: Boolean
////)
//
//data class Ingredient(
//    val name: String,
//    val category: String,
//    val storage: String,
//    var isChecked: Boolean = false,
//    var expiry: String? = null,
//    var count: Int = 1
//)
//
//
//val categoryGroups = mapOf(
//    "채소" to listOf("채소"),
//    "육류와 가공육" to listOf("육류", "가공육"),
//    "유제품과 가공식품" to listOf("유제품", "가공식품"),
//    "양념류" to listOf("장류", "조미료"),
//    "기타" to listOf("통조림", "곡류", "면류", "해산물", "건조식품", "베이커리", "발효식품")
//)
//
//fun loadIngredientsFromAssets(context: Context): List<Ingredient> {
//    val jsonString = context.assets.open("ingredients.json")
//        .bufferedReader().use { it.readText() }
//
//    val gson = Gson()
//    val listType = object : TypeToken<List<Ingredient>>() {}.type
//    return gson.fromJson(jsonString, listType)
//}
//
////@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun ListTabContent(
//    selectedIngredients: MutableState<Set<String>>,
//    ingredientsState: MutableState<List<Ingredient>>,
//    isLoaded: MutableState<Boolean>
//) {
//    val context = LocalContext.current
//
//    LaunchedEffect(Unit) {
//        if (!isLoaded.value) {
//            ingredientsState.value = loadIngredientsFromAssets(context)
//            isLoaded.value = true
//        }
//    }
//
//    val ingredients = ingredientsState.value
//    val groupTitles = listOf("채소", "육류와 가공육", "유제품과 가공식품", "양념류", "기타")
//    val categoryGroups = mapOf(
//        "채소" to listOf("채소"),
//        "육류와 가공육" to listOf("육류", "가공육"),
//        "유제품과 가공식품" to listOf("유제품", "가공식품"),
//        "양념류" to listOf("장류", "조미료"),
//        "기타" to listOf("통조림", "곡류", "면류", "해산물", "건조식품", "베이커리", "발효식품")
//    )
//
//    val pagerState = rememberPagerState(pageCount = { groupTitles.size })
//    val coroutineScope = rememberCoroutineScope()
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        // 카테고리 선택 chip (scrollable)
//        LazyRow(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 12.dp, vertical = 8.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp)
//        ) {
//            itemsIndexed(groupTitles) { index, title ->
//                CategoryChip(
//                    text = title,
//                    selected = index == pagerState.currentPage,
//                    onClick = {
//                        coroutineScope.launch {
//                            pagerState.animateScrollToPage(index)
//                        }
//                    }
//                )
//            }
//        }
////        Spacer(modifier = Modifier.height(8.dp))
////        Divider()
//
//        // 그룹별 재료 리스트: 수평 swipe 가능한 pager
//        HorizontalPager(
//            state = pagerState,
//            modifier = Modifier.weight(1f)
//        ) { page ->
//            val group = groupTitles[page]
//            val subcategories = categoryGroups[group] ?: emptyList()
//            val filteredIngredients = ingredients.filter { it.category in subcategories }
//
//            LazyColumn(modifier = Modifier.fillMaxSize()) {
//                itemsIndexed(filteredIngredients) { index, item ->
//                    IngredientRow(
//                        item = item,
//                        onCheckedChange = { checked ->
//                            val updated = item.copy(isChecked = checked)
//                            val list = ingredients.toMutableList()
//                            val idx = ingredients.indexOfFirst { it.name == item.name }
//                            if (idx != -1) list[idx] = updated
//                            ingredientsState.value = list
//
//                            selectedIngredients.value = if (checked) {
//                                selectedIngredients.value + item.name
//                            } else {
//                                selectedIngredients.value - item.name
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun CategoryChip(text: String, selected: Boolean, onClick: () -> Unit) {
//    Surface(
//        shape = RoundedCornerShape(50),
//        color = if (selected) Color(0xFFBBDEFB) else Color(0xFFE0E0E0),
//        border = BorderStroke(1.dp, if (selected) Color.Blue else Color.Gray),
//        modifier = Modifier.clickable(onClick = onClick)
//    ) {
//        Text(
//            text = text,
//            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
//            color = if (selected) Color.Black else Color.DarkGray
//        )
//    }
//}
//
//@Composable
//fun IngredientRow(item: Ingredient, onCheckedChange: (Boolean) -> Unit) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onCheckedChange(!item.isChecked) }
//            .padding(16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(item.name, Modifier.weight(1f))
//        Checkbox(
//            checked = item.isChecked,
//            onCheckedChange = onCheckedChange
//        )
//    }
//}
//
//@Composable
//fun IngredientInputDialog(
//    ingredientName: String,
//    onConfirm: (String, Int) -> Unit,
//    onDismiss: () -> Unit
//) {
//    var selectedDate by remember { mutableStateOf("") }
//    var count by remember { mutableStateOf(1) }
//
//    AlertDialog(
//        onDismissRequest = onDismiss,
//        confirmButton = {
//            TextButton(onClick = {
//                if (selectedDate.isNotEmpty()) {
//                    onConfirm(selectedDate, count)
//                }
//            }) {
//                Text("확인")
//            }
//        },
//        dismissButton = {
//            TextButton(onClick = onDismiss) {
//                Text("취소")
//            }
//        },
//        title = { Text(text = "유통기한 설정") },
//        text = {
//            Column {
//                Text("재료: $ingredientName")
//                Spacer(Modifier.height(8.dp))
//
//                OutlinedTextField(
//                    value = selectedDate,
//                    onValueChange = { selectedDate = it },
//                    label = { Text("유통기한 (예: 2025/07/10)") },
//                    modifier = Modifier.fillMaxWidth()
//                )
//
//                Spacer(Modifier.height(8.dp))
//
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Text("수량:")
//                    IconButton(onClick = { if (count > 1) count-- }) {
//                        Text("-")
//                    }
//                    Text("$count", modifier = Modifier.padding(horizontal = 12.dp))
//                    IconButton(onClick = { count++ }) {
//                        Text("+")
//                    }
//                }
//            }
//        }
//    )
//}
//

package com.example.madcampproj1.tab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.HorizontalDivider
import android.content.Context
import androidx.compose.foundation.BorderStroke
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextButton
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

import androidx.compose.ui.Alignment

import android.app.DatePickerDialog
import java.util.Calendar


data class Ingredient(
    val name: String,
    val category: String,
    val storage: String,
    var isChecked: Boolean = false,
    var expiry: String? = null,
    var count: Int = 1
)

val categoryGroups = mapOf(
    "채소" to listOf("채소"),
    "육류와 가공육" to listOf("육류", "가공육"),
    "유제품과 가공식품" to listOf("유제품", "가공식품"),
    "양념류" to listOf("장류", "조미료"),
    "기타" to listOf("통조림", "곡류", "면류", "해산물", "건조식품", "베이커리", "발효식품")
)

fun loadIngredientsFromAssets(context: Context): List<Ingredient> {
    val jsonString = context.assets.open("ingredients.json")
        .bufferedReader().use { it.readText() }

    val gson = Gson()
    val listType = object : TypeToken<List<Ingredient>>() {}.type
    return gson.fromJson(jsonString, listType)
}

@Composable
fun ListTabContent(
    selectedIngredients: MutableState<Set<String>>,
    ingredientsState: MutableState<List<Ingredient>>,
    isLoaded: MutableState<Boolean>
) {
    val context = LocalContext.current

    LaunchedEffect(Unit) {
        if (!isLoaded.value) {
            ingredientsState.value = loadIngredientsFromAssets(context)
            isLoaded.value = true
        }
    }

    val ingredients = ingredientsState.value
    val groupTitles = listOf("채소", "육류와 가공육", "유제품과 가공식품", "양념류", "기타")
    val categoryGroups = mapOf(
        "채소" to listOf("채소"),
        "육류와 가공육" to listOf("육류", "가공육"),
        "유제품과 가공식품" to listOf("유제품", "가공식품"),
        "양념류" to listOf("장류", "조미료"),
        "기타" to listOf("통조림", "곡류", "면류", "해산물", "건조식품", "베이커리", "발효식품")
    )

    val pagerState = rememberPagerState(pageCount = { groupTitles.size })
    val coroutineScope = rememberCoroutineScope()

    var showDialog by remember { mutableStateOf(false) }
    var currentIngredientIndex by remember { mutableStateOf(-1) }

    Column(modifier = Modifier.fillMaxSize()) {
        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            itemsIndexed(groupTitles) { index, title ->
                CategoryChip(
                    text = title,
                    selected = index == pagerState.currentPage,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val group = groupTitles[page]
            val subcategories = categoryGroups[group] ?: emptyList()

            // ✅ 검색어 상태 추가 (각 페이지 별로)
            var searchQuery by remember { mutableStateOf("") }

            // ✅ 검색어로 필터링
            val filteredIngredients = ingredients.filter {
                it.category in subcategories && it.name.startsWith(searchQuery)
            }

            Column(modifier = Modifier.fillMaxSize()) {

                // ✅ 여기에 검색창 추가
                OutlinedTextField(
                    value = searchQuery,
                    onValueChange = { searchQuery = it },
                    placeholder = { Text("식재료 검색") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                )

                // ✅ 필터링된 재료 목록
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    itemsIndexed(filteredIngredients) { index, item ->
                        IngredientRow(
                            item = item,
                            onCheckedChange = {
                                currentIngredientIndex = ingredients.indexOfFirst { it.name == item.name }
                                showDialog = true
                            }
                        )
                    }
                }
            }
        }


        if (showDialog && currentIngredientIndex >= 0) {
            val selectedItem = ingredients[currentIngredientIndex]
            IngredientInputDialog(
                ingredientName = selectedItem.name,
                onConfirm = { expiry, count ->
                    val updated = selectedItem.copy(
                        isChecked = true,
                        expiry = expiry,
                        count = count
                    )
                    val updatedList = ingredients.toMutableList()
                    updatedList[currentIngredientIndex] = updated
                    ingredientsState.value = updatedList
                    selectedIngredients.value += selectedItem.name
                    showDialog = false
                },
                onDismiss = {
                    showDialog = false
                }
            )
        }
    }
}

@Composable
fun CategoryChip(text: String, selected: Boolean, onClick: () -> Unit) {
    Surface(
        shape = RoundedCornerShape(50),
        color = if (selected) Color(0xFFBBDEFB) else Color(0xFFE0E0E0),
        border = BorderStroke(1.dp, if (selected) Color.Blue else Color.Gray),
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            color = if (selected) Color.Black else Color.DarkGray
        )
    }
}

//@Composable
//fun IngredientRow(item: Ingredient, onCheckedChange: (Boolean) -> Unit) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .clickable { onCheckedChange(!item.isChecked) }
//            .padding(16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(item.name, Modifier.weight(1f))
//        Checkbox(
//            checked = item.isChecked,
//            onCheckedChange = onCheckedChange
//        )
//    }
//}

@Composable
fun IngredientRow(item: Ingredient, onCheckedChange: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(item.name, Modifier.weight(1f))
        if (item.expiry != null) {
            // 유통기한 라벨
            Surface(
                color = Color(0xFFE0F7FA),
                shape = RoundedCornerShape(8.dp),
                border = BorderStroke(1.dp, Color.Gray),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(
                    text = item.expiry ?: "",
                    modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                    color = Color.DarkGray
                )
            }
        }
        Checkbox(
            checked = item.isChecked,
            onCheckedChange = { onCheckedChange() } // 동작 통일
        )
    }
}

@Composable
fun IngredientInputDialog(
    ingredientName: String,
    onConfirm: (String, Int) -> Unit,
    onDismiss: () -> Unit
) {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    var selectedDate by remember { mutableStateOf("") }
    var count by remember { mutableStateOf(1) }

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                selectedDate = String.format("%04d/%02d/%02d", year, month + 1, dayOfMonth)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            TextButton(onClick = {
                if (selectedDate.isNotEmpty()) {
                    onConfirm(selectedDate, count)
                }
            }) {
                Text("확인")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("취소")
            }
        },
        title = { Text(text = "유통기한 설정") },
        text = {
            Column {
                Text("재료: $ingredientName")
                Spacer(Modifier.height(8.dp))

                Text(
                    text = if (selectedDate.isEmpty()) "날짜를 선택하세요" else "선택된 날짜: $selectedDate",
                    modifier = Modifier
                        .clickable { datePickerDialog.show() }
                        .padding(8.dp)
                )

                Spacer(Modifier.height(8.dp))

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("수량:")
                    IconButton(onClick = { if (count > 1) count-- }) {
                        Text("-")
                    }
                    Text("$count", modifier = Modifier.padding(horizontal = 12.dp))
                    IconButton(onClick = { count++ }) {
                        Text("+")
                    }
                }
            }
        }
    )
}
