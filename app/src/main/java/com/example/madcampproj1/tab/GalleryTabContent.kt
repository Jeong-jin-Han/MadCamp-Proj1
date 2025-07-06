package com.example.madcampproj1.tab
//import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.material3.MaterialTheme
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
//import com.example.madcampproj1.R
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.remember


import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.background


import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.madcampproj1.model.RecipeWithSteps
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.FlowRow

import androidx.compose.ui.layout.ContentScale
import com.example.madcampproj1.model.Recipe
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
//@Suppress("DiscouragedApi")
//@Composable
//fun GalleryTabContent() {
//    val context = LocalContext.current
//
//    // 🔁 이미지 ID 리스트
//    val imageIds = remember {
//        (1..21).mapNotNull { index ->
//            val name = "image$index"
//            val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
//            if (resId != 0) resId else null
//        }
//    }
//
//    // 🌟 상태: 선택된 이미지 인덱스 (기존 selectedImageId → index 기반으로 변경)
//    var selectedImageIndex by remember { mutableStateOf<Int?>(null) }
//
//    if (selectedImageIndex != null) {
//        val pagerState = rememberPagerState(
//            pageCount = { imageIds.size }
//        )
//
//        // 이미지 선택되었을 때 해당 index로 스크롤 이동
//        LaunchedEffect(selectedImageIndex) {
//            pagerState.scrollToPage(selectedImageIndex!!)
//        }
//
//        // 🔍 전체 화면 슬라이드 보기
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .clickable { selectedImageIndex = null }, // 클릭 시 전체 보기 종료
//            contentAlignment = Alignment.Center
//        ) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                HorizontalPager(
//                    state = pagerState,
//                    modifier = Modifier.fillMaxWidth()
//                ) { page ->
//                    Image(
//                        painter = painterResource(id = imageIds[page]),
//                        contentDescription = null,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .aspectRatio(1f)
//                    )
//                }
//
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "이미지: image${pagerState.currentPage + 1}",
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
//        }
//    } else {
//        // 📸 일반 갤러리 그리드 뷰
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(3),
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            contentPadding = PaddingValues(bottom = 80.dp)
//        ) {
//            items(imageIds.size) { index ->
//                Image(
//                    painter = painterResource(id = imageIds[index]),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(1f)
//                        .clickable {
//                            selectedImageIndex = index // 클릭 시 전체 화면 모드 진입
//                        }
//                )
//            }
//        }
//    }
//}


fun loadRecipesFromAssets(context: Context): List<Recipe> {
    val jsonString = context.assets.open("recipes_with_steps.json")
        .bufferedReader()
        .use { it.readText() }

    val gson = Gson()
    val listType = object : TypeToken<List<Recipe>>() {}.type
    return gson.fromJson(jsonString, listType)
}

@Suppress("DiscouragedApi")
@ExperimentalFoundationApi
@Composable
fun GalleryTabContent(
    selectedIngredients: Set<String>
) {
    val context = LocalContext.current

    // 🔁 전체 레시피 로드 (처음 1회)
    val allRecipes = remember { mutableStateOf<List<RecipeWithSteps>>(emptyList()) }

    LaunchedEffect(Unit) {
        val jsonString = context.assets.open("recipes_with_steps.json").bufferedReader().use { it.readText() }
        val gson = Gson()
        val listType = object : TypeToken<List<RecipeWithSteps>>() {}.type
        allRecipes.value = gson.fromJson(jsonString, listType)
    }

//    // 🔍 추천 레시피 정렬 (재료 차이 적은 순)
//    val recommendedRecipes = remember(allRecipes.value, selectedIngredients) {
//        allRecipes.value
//            .map { recipe ->
//                val missingCount = recipe.ingredients.count { it !in selectedIngredients }
//                recipe to missingCount
//            }
//            .sortedBy { it.second }
//            .map { it.first }
//            .take(21)
//    }
//    val recommendedRecipes = remember(allRecipes.value, selectedIngredients) {
//        allRecipes.value
//            .map { recipe ->
//                val matchedCount = recipe.ingredients.count { it in selectedIngredients }
//                recipe to matchedCount
//            }
//            .sortedByDescending { it.second } // matchedCount 내림차순
//            .map { it.first }
//            .take(21)
//    }

    val recommendedRecipes = remember(allRecipes.value, selectedIngredients) {
        allRecipes.value
            .map { recipe ->
                val matchedCount = recipe.ingredients.count { it in selectedIngredients }
                val missingCount = recipe.ingredients.count { it !in selectedIngredients }
                Triple(recipe, matchedCount, missingCount)
            }
            .sortedWith(
                compareByDescending<Triple<RecipeWithSteps, Int, Int>> { it.second }.thenBy { it.third }                                     // missingCount ↑
            )
            .map { it.first }
            .take(21)
    }


    // 🔍 이미지 리소스 ID 매핑
    val imageIds = recommendedRecipes.mapNotNull { recipe ->
        val resId = context.resources.getIdentifier(recipe.image, "drawable", context.packageName)
        if (resId != 0) resId else null
    }

    // 전체화면 보기용 상태
    var selectedIndex by remember { mutableStateOf<Int?>(null) }

    if (selectedIndex != null) {
        val pagerState = rememberPagerState(pageCount = { recommendedRecipes.size })

        LaunchedEffect(selectedIndex) {
            pagerState.scrollToPage(selectedIndex!!)
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .clickable { selectedIndex = null }
        ) {
            HorizontalPager(state = pagerState) { page ->
                val recipe = recommendedRecipes[page]
                val resId = context.resources.getIdentifier(recipe.image, "drawable", context.packageName)

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(recipe.name, style = MaterialTheme.typography.titleLarge)

                    Spacer(Modifier.height(8.dp))

                    val missingIngredients = recipe.ingredients.filter { it !in selectedIngredients }
                    @OptIn(ExperimentalLayoutApi::class)
                    FlowRow {
                        recipe.ingredients.forEach { ingredient ->
                            val color = if (ingredient in selectedIngredients) Color.Black else Color.Red
                            Text(
                                text = ingredient,
                                color = color,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(4.dp) // 약간의 간격 주고 싶으면 여기서 설정
                            )
                        }
                    }




                    Spacer(Modifier.height(8.dp))

                    Image(
                        painter = painterResource(id = resId),
                        contentDescription = recipe.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(Modifier.height(10.dp))
                    Text(
                        text = "레시피",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(Modifier.height(10.dp))
                    Column(
                        verticalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        recipe.steps.forEach { step ->
                            Text(text = step, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            itemsIndexed(recommendedRecipes) { index, recipe ->
                val resId = context.resources.getIdentifier(recipe.image, "drawable", context.packageName)
                Image(
                    painter = painterResource(id = resId),
                    contentDescription = recipe.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clickable { selectedIndex = index }
                )
            }
        }
    }
}








//@Composable
//fun GalleryTabContent() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text("여기에 이미지 갤러리 표시")
//    }
//}

//@Suppress("DiscouragedApi")
//@Composable
//fun GalleryTabContent() {
//    val context = LocalContext.current
//
//    // 자동으로 image1 ~ image20 불러오기
//    val imageIds = remember {
//        (1..21).mapNotNull { index ->
//            val name = "image$index"
//            val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
//            if (resId != 0) resId else null
//        }
//    }
//
//    LazyVerticalGrid(
//        columns = GridCells.Fixed(3),
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp),
//        horizontalArrangement = Arrangement.spacedBy(8.dp),
//        verticalArrangement = Arrangement.spacedBy(8.dp),
////        contentPadding = PaddingValues(8.dp)
//        contentPadding = PaddingValues(bottom = 80.dp) // 👈 하단 여백 추가!
//    ) {
//        items(imageIds.size) { index ->
//            Image(
//                painter = painterResource(id = imageIds[index]),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .aspectRatio(1f)
//            )
//        }
//    }
//}


//@Suppress("DiscouragedApi")
//@Composable
//fun GalleryTabContent() {
//    val context = LocalContext.current
//
//    // 🔁 이미지 ID 리스트
//    val imageIds = remember {
//        (1..21).mapNotNull { index ->
//            val name = "image$index"
//            val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
//            if (resId != 0) resId else null
//        }
//    }
//
//    // 🌟 상태: 선택된 이미지 ID
//    var selectedImageId by remember { mutableStateOf<Int?>(null) }
//
//    // 👉 전체 화면 보기
//    if (selectedImageId != null) {
//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .clickable { selectedImageId = null }, // 클릭 시 닫기
//            contentAlignment = Alignment.Center
//        ) {
//            Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                Image(
//                    painter = painterResource(id = selectedImageId!!),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(1f)
//                )
//                Spacer(modifier = Modifier.height(8.dp))
//                Text(
//                    text = "이미지: image${imageIds.indexOf(selectedImageId!!) + 1}",
//                    style = MaterialTheme.typography.bodyLarge
//                )
//            }
//        }
//    } else {
//        // 👇 갤러리 뷰
//        LazyVerticalGrid(
//            columns = GridCells.Fixed(3),
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(8.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            contentPadding = PaddingValues(bottom = 80.dp)
//        ) {
//            items(imageIds.size) { index ->
//                Image(
//                    painter = painterResource(id = imageIds[index]),
//                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .aspectRatio(1f)
//                        .clickable { selectedImageId = imageIds[index] } // 클릭 시 확대
//                )
//            }
//        }
//    }
//}