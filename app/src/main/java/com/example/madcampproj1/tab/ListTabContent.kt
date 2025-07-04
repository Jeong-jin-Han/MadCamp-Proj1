package com.example.madcampproj1.tab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Divider
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
//import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color

//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp

// 🔽 HorizontalPager 관련
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.pager.PagerState
// LazyRow 및 LazyColumn 관련
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import kotlinx.coroutines.launch

//@Composable
//fun ListTabContent() {
//    // 하드코딩된 샘플 아이템
//    val itemList = listOf(
//        "사과",
//        "바나나",
//        "체리",
//        "딸기",
//        "수박",
//        "포도",
//        "복숭아",
//        "레몬"
//    )
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp)
//    ) {
//        items(itemList) { item ->
//            Column(modifier = Modifier.padding(vertical = 8.dp)) {
//                Text(
//                    text = item,
//                    style = MaterialTheme.typography.bodyLarge
//                )
//                HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
//            }
//        }
//    }
//}

//@Composable
//fun ListTabContent() {
//    val itemList = listOf(
//        "사과", "바나나", "체리", "딸기", "수박", "포도", "복숭아", "레몬"
//    )
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp) // ← 여기가 핵심!
//    ) {
//        items(itemList) { item ->
//            Column {
//                Text(
//                    text = item,
//                    style = MaterialTheme.typography.bodyLarge
//                )
//                HorizontalDivider()
//            }
//        }
//    }
//}

//data class Place(
//    val name: String,
//    val category: String,
//    val address: String
//)
//
//fun loadPlacesFromAssets(context: Context): List<Place> {
//    val jsonString = context.assets.open("sample_data.json")
//        .bufferedReader()
//        .use { it.readText() }
//
//    val gson = Gson()
//    val listType = object : TypeToken<List<Place>>() {}.type
//    return gson.fromJson(jsonString, listType)
//}
//
//@Composable
//fun ListTabContent() {
//    val context = LocalContext.current
//    val placeList by remember {
//        mutableStateOf(loadPlacesFromAssets(context))
//    }
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        contentPadding = PaddingValues(bottom = 80.dp) // 👈 하단 여백 추가!
//    ) {
//        items(placeList) { place ->
//            Column {
//                Text(text = place.name, style = MaterialTheme.typography.titleMedium)
//                Text(text = place.category)
//                Text(text = place.address)
//                HorizontalDivider()
//            }
//        }
//    }
//}

//data class Ingredient(
//    val name: String
//    // val category: String? = null,      // 필요한 경우 사용
//    // val storage: String? = null        // 예: 냉장, 냉동, 실온 등
//)
//
//fun loadIngredientsFromAssets(context: Context): List<Ingredient> {
//    val jsonString = context.assets.open("ingredients.json")
//        .bufferedReader()
//        .use { it.readText() }
//
//    val gson = Gson()
//    val listType = object : TypeToken<List<Ingredient>>() {}.type
//    return gson.fromJson(jsonString, listType)
//}
//
//@Composable
//fun ListTabContent() {
//    val context = LocalContext.current
//    val ingredientList by remember {
//        mutableStateOf(loadIngredientsFromAssets(context))
//    }
//
//    LazyColumn(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
//        contentPadding = PaddingValues(bottom = 80.dp)
//    ) {
//        items(ingredientList) { ingredient ->
//            Column {
//                Text(text = ingredient.name, style = MaterialTheme.typography.titleMedium)
//                HorizontalDivider()
//            }
//        }
//    }
//}

//fun loadIngredientsFromAssets(context: Context): List<Ingredient> {
//    val jsonString = context.assets.open("ingredients.json")
//        .bufferedReader().use { it.readText() }
//
//    val gson = Gson()
//    val listType = object : TypeToken<List<Ingredient>>() {}.type
//    return gson.fromJson(jsonString, listType)
//}
//
//data class Ingredient(val name: String, var isChecked: Boolean)
//
//
//@Composable
//fun ListTabContent() {
//    val context = LocalContext.current
//
//    var ingredients by remember { mutableStateOf<List<Ingredient>>(emptyList()) }
//
//    // 처음 1회만 JSON 로드
//    LaunchedEffect(Unit) {
//        ingredients = loadIngredientsFromAssets(context)
//    }
//
//    LazyColumn {
//        itemsIndexed(ingredients) { index, item ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable {
//                        ingredients = ingredients.toMutableList().also {
//                            it[index] = it[index].copy(isChecked = !it[index].isChecked)
//                        }
//                    }
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    text = item.name,
//                    modifier = Modifier.weight(1f)
//                )
//                Checkbox(
//                    checked = item.isChecked,
//                    onCheckedChange = { isChecked ->
//                        ingredients = ingredients.toMutableList().also {
//                            it[index] = it[index].copy(isChecked = isChecked)
//                        }
//                    }
//                )
//            }
//        }
//    }
//}



//data class Ingredient(
//    val name: String,
//    val storage: String,
//    var isChecked: Boolean
//)

data class Ingredient(
    val name: String,
    val category: String,
    val storage: String,
    var isChecked: Boolean
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

//@Composable
//fun ListTabContent(
//    selectedIngredients: MutableState<Set<String>>,
//    ingredientsState: MutableState<List<Ingredient>>,
//    isLoaded: MutableState<Boolean>
//) {
//    val context = LocalContext.current
//
////    // 초기 1회만 JSON에서 로드
////    LaunchedEffect(Unit) {
////        val loaded = loadIngredientsFromAssets(context)
////        ingredientsState.value = loaded
////    }
////    val isLoaded = remember { mutableStateOf(false) }
//
//    LaunchedEffect(Unit) {
//        if (!isLoaded.value) {
//            val loaded = loadIngredientsFromAssets(context)
//            ingredientsState.value = loaded
//            isLoaded.value = true
//        }
//    }
//
//    val ingredients = ingredientsState.value
//
//    LazyColumn {
//        itemsIndexed(ingredients) { index, item ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable {
//                        val updated = item.copy(isChecked = !item.isChecked)
//                        ingredientsState.value = ingredients.toMutableList().also {
//                            it[index] = updated
//                        }
//
//                        selectedIngredients.value = if (updated.isChecked) {
//                            selectedIngredients.value + updated.name
//                        } else {
//                            selectedIngredients.value - updated.name
//                        }
//                    }
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(item.name, Modifier.weight(1f))
//                Checkbox(
//                    checked = item.isChecked,
//                    onCheckedChange = { checked ->
//                        val updated = item.copy(isChecked = checked)
//                        ingredientsState.value = ingredients.toMutableList().also {
//                            it[index] = updated
//                        }
//
//                        selectedIngredients.value = if (checked) {
//                            selectedIngredients.value + updated.name
//                        } else {
//                            selectedIngredients.value - updated.name
//                        }
//                    }
//                )
//            }
//        }
//    }
//}


//
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
//            val loaded = loadIngredientsFromAssets(context)
//            ingredientsState.value = loaded
//            isLoaded.value = true
//        }
//    }
//
//    val ingredients = ingredientsState.value
//
//    val categoryGroups = mapOf(
//        "채소" to listOf("채소"),
//        "육류와 가공육" to listOf("육류", "가공육"),
//        "유제품과 가공식품" to listOf("유제품", "가공식품"),
//        "양념류" to listOf("장류", "조미료"),
//        "기타" to listOf("통조림", "곡류", "면류", "해산물", "건조식품", "베이커리", "발효식품")
//    )
//
//    val groupedIngredients = remember(ingredients) {
//        categoryGroups.mapValues { (_, subcategories) ->
//            ingredients.filter { it.category in subcategories }
//                .groupBy { it.category }  // 하위 카테고리 기준으로 그룹핑
//        }
//    }
//
//    LazyColumn(modifier = Modifier.fillMaxSize()) {
//        groupedIngredients.forEach { (mainCategory, subGroup) ->
//            item {
//                Text(
//                    text = "🔹 $mainCategory",
//                    style = MaterialTheme.typography.titleMedium,
//                    modifier = Modifier.padding(12.dp)
//                )
//            }
//
//            subGroup.forEach { (subCategory, items) ->
//                item {
//                    Text(
//                        text = "   ▶ $subCategory",
//                        style = MaterialTheme.typography.bodyMedium,
//                        modifier = Modifier.padding(start = 20.dp, bottom = 4.dp)
//                    )
//                }
//
//                itemsIndexed(items) { index, item ->
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .clickable {
//                                val updated = item.copy(isChecked = !item.isChecked)
//                                val updatedList = ingredients.toMutableList()
//                                val realIndex = ingredients.indexOfFirst { it.name == item.name }
//                                if (realIndex != -1) {
//                                    updatedList[realIndex] = updated
//                                    ingredientsState.value = updatedList
//                                }
//
//                                selectedIngredients.value = if (updated.isChecked) {
//                                    selectedIngredients.value + updated.name
//                                } else {
//                                    selectedIngredients.value - updated.name
//                                }
//                            }
//                            .padding(horizontal = 24.dp, vertical = 8.dp),
//                        verticalAlignment = Alignment.CenterVertically
//                    ) {
//                        Text(item.name, Modifier.weight(1f))
//                        Checkbox(
//                            checked = item.isChecked,
//                            onCheckedChange = { checked ->
//                                val updated = item.copy(isChecked = checked)
//                                val updatedList = ingredients.toMutableList()
//                                val realIndex = ingredients.indexOfFirst { it.name == item.name }
//                                if (realIndex != -1) {
//                                    updatedList[realIndex] = updated
//                                    ingredientsState.value = updatedList
//                                }
//
//                                selectedIngredients.value = if (checked) {
//                                    selectedIngredients.value + updated.name
//                                } else {
//                                    selectedIngredients.value - updated.name
//                                }
//                            }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//


//@OptIn(ExperimentalFoundationApi::class)
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

    Column(modifier = Modifier.fillMaxSize()) {
        // 카테고리 선택 chip (scrollable)
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
//        Spacer(modifier = Modifier.height(8.dp))
//        Divider()

        // 그룹별 재료 리스트: 수평 swipe 가능한 pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            val group = groupTitles[page]
            val subcategories = categoryGroups[group] ?: emptyList()
            val filteredIngredients = ingredients.filter { it.category in subcategories }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(filteredIngredients) { index, item ->
                    IngredientRow(
                        item = item,
                        onCheckedChange = { checked ->
                            val updated = item.copy(isChecked = checked)
                            val list = ingredients.toMutableList()
                            val idx = ingredients.indexOfFirst { it.name == item.name }
                            if (idx != -1) list[idx] = updated
                            ingredientsState.value = list

                            selectedIngredients.value = if (checked) {
                                selectedIngredients.value + item.name
                            } else {
                                selectedIngredients.value - item.name
                            }
                        }
                    )
                }
            }
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

@Composable
fun IngredientRow(item: Ingredient, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onCheckedChange(!item.isChecked) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(item.name, Modifier.weight(1f))
        Checkbox(
            checked = item.isChecked,
            onCheckedChange = onCheckedChange
        )
    }
}



//@Composable
//fun ListTabContent(selectedIngredients: MutableState<Set<String>>) {
//    val context = LocalContext.current
//    var ingredients by remember { mutableStateOf<List<Ingredient>>(emptyList()) }
//
//    LaunchedEffect(Unit) {
//        ingredients = loadIngredientsFromAssets(context)
//    }
//
//    LazyColumn {
//        itemsIndexed(ingredients) { index, item ->
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .clickable {
//                        ingredients = ingredients.toMutableList().also {
//                            val updated = it[index].copy(isChecked = !it[index].isChecked)
//                            it[index] = updated
//                            selectedIngredients.value = if (updated.isChecked) {
//                                selectedIngredients.value + updated.name
//                            } else {
//                                selectedIngredients.value - updated.name
//                            }
//                        }
//                    }
//                    .padding(16.dp),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(item.name, Modifier.weight(1f))
//                Checkbox(
//                    checked = item.isChecked,
//                    onCheckedChange = { checked ->
//                        ingredients = ingredients.toMutableList().also {
//                            val updated = it[index].copy(isChecked = checked)
//                            it[index] = updated
//                            selectedIngredients.value = if (checked) {
//                                selectedIngredients.value + updated.name
//                            } else {
//                                selectedIngredients.value - updated.name
//                            }
//                        }
//                    }
//                )
//            }
//        }
//    }
//}
//
