//package com.example.madcampproj1
//
//
//import com.example.madcampproj1.tab.ListTabContent
//import com.example.madcampproj1.tab.GalleryTabContent
//import com.example.madcampproj1.tab.FreeTabContent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
//import androidx.compose.animation.core.*
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.pager.*
//import androidx.compose.material3.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.composed
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.debugInspectorInfo
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.IntOffset
//import androidx.compose.ui.unit.dp
//import com.example.madcampproj1.ui.theme.MadCampProj1Theme
//import kotlinx.coroutines.launch
//
//
//import androidx.compose.animation.AnimatedVisibility
//import androidx.compose.foundation.border
//import androidx.compose.foundation.lazy.LazyRow
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.Add
//import androidx.compose.material.icons.filled.Kitchen
//
//import com.example.madcampproj1.tab.Ingredient
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
//        setContent {
//            MadCampProj1Theme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
////                    Greeting(
////                        name = "Android",
////                        modifier = Modifier.padding(innerPadding)
////                    )
//                    MainTabs(innerPadding)
//                }
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun MainTabs(innerPadding: PaddingValues) {
//    val tabs = listOf("리스트", "갤러리", "자유")
//    var selectedTabIndex by remember { mutableStateOf(0) }
//    var isPopupVisible by remember { mutableStateOf(false) }
//
//    // ✅ 공통 상태
//    val selectedIngredients = remember { mutableStateOf(setOf<String>()) }
//    val ingredientsState = remember { mutableStateOf<List<Ingredient>>(emptyList()) }
//    val isLoaded = remember { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(innerPadding)
//    ) {
//        // 🧊 상단 아이콘 영역
//        SharedHeader(
//            isPopupVisible = isPopupVisible,
//            onFridgeClick = { isPopupVisible = !isPopupVisible },
//            onAddClick = { /* + 버튼 나중에 */ }
//        )
//
//        // 🔽 팝업 (냉장 / 냉동)
//        AnimatedVisibility(visible = isPopupVisible) {
//            FridgePopup(
//                selectedIngredients = selectedIngredients.value,
//                ingredients = ingredientsState.value
//            )
//        }
//
//        // ✅ 콘텐츠 영역 (탭에 따라)
//        Box(modifier = Modifier.weight(1f)) {
//            when (selectedTabIndex) {
//                0 -> ListTabContent(
//                    selectedIngredients = selectedIngredients,
//                    ingredientsState = ingredientsState,
//                    isLoaded = isLoaded
//                )
//                1 -> GalleryTabContent(selectedIngredients = selectedIngredients.value)
//                2 -> FreeTabContent()
//            }
//        }
//
//        // ⬇️ 하단 탭
//        TabRow(
//            selectedTabIndex = selectedTabIndex,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            tabs.forEachIndexed { index, title ->
//                Tab(
//                    text = { Text(title) },
//                    selected = selectedTabIndex == index,
//                    onClick = { selectedTabIndex = index }
//                )
//            }
//        }
//    }
//}
//
//
//@Composable
//fun SharedHeader(
//    isPopupVisible: Boolean,
//    onFridgeClick: () -> Unit,
//    onAddClick: () -> Unit
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp),
//        horizontalArrangement = Arrangement.SpaceBetween
//    ) {
//        IconButton(onClick = onFridgeClick) {
//            Icon(Icons.Default.Kitchen, contentDescription = "냉장고")
//        }
//
//        IconButton(onClick = onAddClick) {
//            Icon(Icons.Default.Add, contentDescription = "추가")
//        }
//    }
//}
//
//
//data class Ingredient(
//    val name: String,
//    val storage: String,
//    var isChecked: Boolean
//)
//
//@Composable
//fun FridgePopup(selectedIngredients: Set<String>, ingredients: List<Ingredient>) {
//    val fridgeItems = ingredients.filter { it.name in selectedIngredients && it.storage == "냉장" }
//    val freezerItems = ingredients.filter { it.name in selectedIngredients && it.storage == "냉동" }
//    val roomItems = ingredients.filter { it.name in selectedIngredients && it.storage == "실온" }
//
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFE0F7FA))
//            .padding(16.dp)
//    ) {
//        Text("냉장", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(fridgeItems) { item ->
//                TextBox(item.name)
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        Text("냉동", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(freezerItems) { item ->
//                TextBox(item.name)
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        Text("실온", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(roomItems) { item ->
//                TextBox(item.name)
//            }
//        }
//    }
//}
//
//@Composable
//fun TextBox(text: String) {
//    Box(
//        modifier = Modifier
//            .padding(8.dp)
//            .background(Color.White)
//            .border(1.dp, Color.Gray)
//            .padding(8.dp)
//    ) {
//        Text(text)
//    }
//}
//


package com.example.madcampproj1


import com.example.madcampproj1.tab.ListTabContent
import com.example.madcampproj1.tab.GalleryTabContent
import com.example.madcampproj1.tab.FreeTabContent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.madcampproj1.ui.theme.MadCampProj1Theme
import kotlinx.coroutines.launch


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.border
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Kitchen

import com.example.madcampproj1.tab.Ingredient

import androidx.compose.foundation.clickable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MadCampProj1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    MainTabs(innerPadding)
                }
            }
        }
    }
}



@Composable
fun MainTabs(innerPadding: PaddingValues) {
    val tabs = listOf("리스트", "갤러리", "자유")
    var selectedTabIndex by remember { mutableStateOf(0) }
    var isPopupVisible by remember { mutableStateOf(false) }

    // ✅ 공통 상태
    val selectedIngredients = remember { mutableStateOf(setOf<String>()) }
    val ingredientsState = remember { mutableStateOf<List<Ingredient>>(emptyList()) }
    val isLoaded = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        // 🧊 상단 아이콘 영역
        SharedHeader(
            isPopupVisible = isPopupVisible,
            onFridgeClick = { isPopupVisible = !isPopupVisible },
            onAddClick = { /* + 버튼 나중에 */ }
        )

        // 🔽 팝업 (냉장 / 냉동)
        AnimatedVisibility(visible = isPopupVisible) {
//            FridgePopup(
//                selectedIngredients = selectedIngredients.value,
//                ingredients = ingredientsState.value
//            )
        FridgePopup(
            selectedIngredients = selectedIngredients,        // ✅ 전체 MutableState 넘김
            ingredientsState = ingredientsState
        )
        }

        // ✅ 콘텐츠 영역 (탭에 따라)
        Box(modifier = Modifier.weight(1f)) {
            when (selectedTabIndex) {
                0 -> ListTabContent(
                    selectedIngredients = selectedIngredients,
                    ingredientsState = ingredientsState,
                    isLoaded = isLoaded
                )
                1 -> GalleryTabContent(selectedIngredients = selectedIngredients.value)
                2 -> FreeTabContent()
            }
        }

        // ⬇️ 하단 탭
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth()
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }
    }
}


@Composable
fun SharedHeader(
    isPopupVisible: Boolean,
    onFridgeClick: () -> Unit,
    onAddClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        IconButton(onClick = onFridgeClick) {
            Icon(Icons.Default.Kitchen, contentDescription = "냉장고")
        }

        IconButton(onClick = onAddClick) {
            Icon(Icons.Default.Add, contentDescription = "추가")
        }
    }
}


data class Ingredient(
    val name: String,
    val storage: String,
    var isChecked: Boolean
)

@Composable
fun FridgePopup(
    selectedIngredients: MutableState<Set<String>>,
    ingredientsState: MutableState<List<Ingredient>>
) {
    val fridgeItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉장" }
    val freezerItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉동" }
    val roomItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "실온" }


    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE0F7FA))
            .padding(16.dp)
    ) {
        Text("냉장", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(fridgeItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }

        Spacer(Modifier.height(12.dp))

        Text("냉동", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(freezerItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }

        Spacer(Modifier.height(12.dp))

        Text("실온", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(roomItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }
    }
}

@Composable
fun TextBox(text: String, onDoubleClick: () -> Unit) {
    var lastClickTime by remember { mutableStateOf(0L) }
    Box(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .border(1.dp, Color.Gray)
            .clickable {
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastClickTime < 300) {
                    onDoubleClick()
                }
                lastClickTime = currentTime
            }
            .padding(8.dp)
    ) {
        Text(text)
    }
}

fun removeIngredientByName(
    name: String,
    selectedIngredients: MutableState<Set<String>>,
    ingredientsState: MutableState<List<Ingredient>>
) {
    // ✅ 강제 업데이트 되도록 새 Set 생성
    selectedIngredients.value = selectedIngredients.value.toMutableSet().apply {
        remove(name)
    }.toSet()

    val updated = ingredientsState.value.map {
        if (it.name == name) it.copy(isChecked = false, expiry = null, count = 1)
        else it
    }
    ingredientsState.value = updated
}
