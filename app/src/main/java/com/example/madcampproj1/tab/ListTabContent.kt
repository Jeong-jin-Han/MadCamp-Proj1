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
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
//import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.foundation.clickable
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Checkbox
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp


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
data class Ingredient(val name: String, var isChecked: Boolean)


@Composable
fun ListTabContent() {
    // ✅ rememberSaveable로 체크 상태를 저장
    var ingredients by rememberSaveable {
        mutableStateOf(
            listOf(
                Ingredient("계란", false),
                Ingredient("우유", false),
                Ingredient("치즈", false),
                Ingredient("스팸", false),
                Ingredient("참치캔", false),
                Ingredient("소시지", false),
                Ingredient("두부", false),
                Ingredient("밥", false),
                Ingredient("양파", false),
                Ingredient("대파", false),
                Ingredient("당근", false),
                Ingredient("감자", false),
                Ingredient("김치", false),
                Ingredient("청양고추 / 일반고추", false),
                Ingredient("상추", false),
                Ingredient("양배추", false),
                Ingredient("팽이버섯", false),
                Ingredient("느타리버섯 / 양송이버섯", false),
                Ingredient("사과사", false)
            )
        )
    }

    LazyColumn {
        itemsIndexed(ingredients) { index, item ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        // ✅ 클릭하면 체크 상태 토글
                        ingredients = ingredients.toMutableList().also {
                            it[index] = it[index].copy(isChecked = !it[index].isChecked)
                        }
                    }
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = item.name,
                    modifier = Modifier.weight(1f)
                )
                Checkbox(
                    checked = item.isChecked,
                    onCheckedChange = { isChecked ->
                        ingredients = ingredients.toMutableList().also {
                            it[index] = it[index].copy(isChecked = isChecked)
                        }
                    }
                )
            }
        }
    }
}
