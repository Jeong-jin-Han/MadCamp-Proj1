//package com.example.madcampproj1
//
//
//import com.example.madcampproj1.tab.ListTabContent
//import com.example.madcampproj1.tab.GalleryTabContent
//import com.example.madcampproj1.tab.FreeTabContent
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.widget.ImageButton
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
//import androidx.compose.material.icons.filled.Close
//
//
//import androidx.compose.material.icons.filled.FoodBank
//import androidx.compose.material.icons.filled.MenuBook
//import androidx.compose.material.icons.filled.TravelExplore
//
//import com.example.madcampproj1.tab.Ingredient
//
//import androidx.compose.foundation.clickable
//import androidx.compose.foundation.horizontalScroll
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.ui.viewinterop.AndroidView
//
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
//data class Ingredient(
//    val name: String,
//    val storage: String,
//    var isChecked: Boolean
//)


//@Composable
//fun MainTabs(innerPadding: PaddingValues) {
//    val tabs = listOf("식재료", "추천요리", "커뮤니티")
//    val icons = listOf(
//        Icons.Filled.FoodBank,
//        Icons.Filled.MenuBook,
//        Icons.Filled.TravelExplore
//    )
//    var selectedTabIndex by remember { mutableStateOf(0) }
//    var isPopupVisible by remember { mutableStateOf(false) }
//
//    // 공통 상태
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
//                selectedIngredients = selectedIngredients,        // 전체 MutableState 넘김
//                ingredientsState = ingredientsState
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
//        Box(modifier = Modifier.fillMaxWidth()) {
//            TabRow(
//                selectedTabIndex = selectedTabIndex,
//                modifier = Modifier.fillMaxWidth(),
//                indicator = { /* 필요시 인디케이터 설정 */ }
//            ) {
//                tabs.forEachIndexed { index, title ->
//                    Tab(
//                        selected = selectedTabIndex == index,
//                        onClick = { selectedTabIndex = index },
//                        text = {
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//                                Icon(
//                                    imageVector = icons[index],
//                                    contentDescription = title,
//                                    modifier = Modifier.size(24.dp)
//                                )
//                                Spacer(modifier = Modifier.height(4.dp))
//                                Text(text = title)
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
//
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

//@Composable
//fun MainTabs(innerPadding: PaddingValues) {
//    val tabs = listOf("식재료", "추천요리", "커뮤니티")
//    val icons = listOf(
//        Icons.Filled.FoodBank,
//        Icons.Filled.MenuBook,
//        Icons.Filled.TravelExplore
//    )
//    var selectedTabIndex by remember { mutableStateOf(0) }
//    var isPopupVisible by remember { mutableStateOf(false) }
//
//    // 공통 상태
//    val selectedIngredients = remember { mutableStateOf(setOf<String>()) }
//    val ingredientsState = remember { mutableStateOf<List<Ingredient>>(emptyList()) }
//    val isLoaded = remember { mutableStateOf(false) }
//
//    // 냉장고 아이콘 추가 상태
//    val fridgeIcons = remember { mutableStateListOf<@Composable () -> Unit>() }
//
//    // + 버튼 클릭 시 동작
//    val onAddClick = {
//        // tab3에서만 냉장고 아이콘 추가 가능
//        if (selectedTabIndex == 2) {
//            fridgeIcons.add {
//                Icon(Icons.Filled.Kitchen, contentDescription = "냉장고")
//            }
//        }
//    }
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
//            onAddClick = onAddClick,
//            fridgeIcons = fridgeIcons // Add fridgeIcons to SharedHeader
//        )
//
//        // 🔽 팝업 (냉장 / 냉동)
//        AnimatedVisibility(visible = isPopupVisible) {
//            FridgePopup(
//                selectedIngredients = selectedIngredients,        // 전체 MutableState 넘김
//                ingredientsState = ingredientsState
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
//        Box(modifier = Modifier.fillMaxWidth()) {
//            TabRow(
//                selectedTabIndex = selectedTabIndex,
//                modifier = Modifier.fillMaxWidth(),
//                indicator = { /* 필요시 인디케이터 설정 */ }
//            ) {
//                tabs.forEachIndexed { index, title ->
//                    Tab(
//                        selected = selectedTabIndex == index,
//                        onClick = { selectedTabIndex = index },
//                        text = {
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//                                Icon(
//                                    imageVector = icons[index],
//                                    contentDescription = title,
//                                    modifier = Modifier.size(24.dp)
//                                )
//                                Spacer(modifier = Modifier.height(4.dp))
//                                Text(text = title)
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//
//@Composable
//fun SharedHeader(
//    isPopupVisible: Boolean,
//    onFridgeClick: () -> Unit,
//    onAddClick: () -> Unit,
//    fridgeIcons: MutableList<@Composable () -> Unit> // Add fridgeIcons as parameter
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .height(48.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // 좌측 냉장고 아이콘들
//        Column(modifier = Modifier.weight(1f)) {
//            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//                // 기본 냉장고 아이콘 추가
//                IconButton(onClick = onFridgeClick) {
//                    Icon(Icons.Default.Kitchen, contentDescription = "냉장고")
//                }
//            }
//        }
//
//        // 중간 공간 (빈 공간)
//        Column(modifier = Modifier.weight(1f)) {
//            // 이곳은 빈 공간
//        }
//
//        // 우측 + 버튼 고정
//        Column(modifier = Modifier) {
//            IconButton(onClick = onAddClick) {
//                Icon(Icons.Default.Add, contentDescription = "추가")
//            }
//        }
//    }
//}
//
//
//@Composable
//fun FridgePopup(
//    selectedIngredients: MutableState<Set<String>>,
//    ingredientsState: MutableState<List<Ingredient>>
//) {
//    val fridgeItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉장" }
//    val freezerItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉동" }
//    val roomItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "실온" }
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
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                })
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        Text("냉동", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(freezerItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                })
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        Text("실온", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(roomItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                })
//            }
//        }
//    }
//}

//@Composable
//fun MainTabs(innerPadding: PaddingValues) {
//    val tabs = listOf("식재료", "추천요리", "커뮤니티")
//    val icons = listOf(
//        Icons.Filled.FoodBank,
//        Icons.Filled.MenuBook,
//        Icons.Filled.TravelExplore
//    )
//    var selectedTabIndex by remember { mutableStateOf(0) }
//    var isPopupVisible by remember { mutableStateOf(false) }
//    var isMiddlePopupVisible by remember { mutableStateOf(false) }
//
//    // 공통 상태
//    val selectedIngredients = remember { mutableStateOf(setOf<String>()) }
//    val ingredientsState = remember { mutableStateOf<List<Ingredient>>(emptyList()) }
//    val isLoaded = remember { mutableStateOf(false) }
//
//    // 냉장고 아이콘 추가 상태
//    val fridgeIcons = remember { mutableStateListOf<@Composable () -> Unit>() }
//    val fixedFridgeIcon = @Composable {
//        Icon(Icons.Filled.Kitchen, contentDescription = "기본 냉장고")
//    }
//
//    // + 버튼 클릭 시 동작
//    val onAddClick = {
//        if (selectedTabIndex == 2) {  // tab3에서만 냉장고 아이콘 추가 가능
//            fridgeIcons.add {
//                Icon(Icons.Filled.Kitchen, contentDescription = "새로운 냉장고")
//            }
//        }
//    }
//
//    // 냉장고 아이콘 클릭 시 팝업을 띄우는 함수
////    val onFridgeClick = { fridgeIcon: @Composable () -> Unit ->
////        if (fridgeIcon == fixedFridgeIcon) {
////            isPopupVisible = !isPopupVisible // 기본 냉장고 팝업을 열거나 닫기
////        } else {
////            isMiddlePopupVisible = !isMiddlePopupVisible // 중간 냉장고 아이콘 팝업을 열거나 닫기
////        }
////    }
//
//    val onFridgeClick = { fridgeIcon: @Composable () -> Unit ->
//        if (fridgeIcon == fixedFridgeIcon) {
//            // 기본 냉장고 팝업을 열고, 중간 냉장고 팝업은 닫음
//            isPopupVisible = true
//            isMiddlePopupVisible = false
//        } else {
//            // 중간 냉장고 팝업을 열고, 기본 냉장고 팝업은 닫음
//            isMiddlePopupVisible = true
//            isPopupVisible = false
//        }
//    }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(innerPadding)
//    ) {
//        // 🧊 상단 아이콘 영역
//        SharedHeader(
//            isPopupVisible = isPopupVisible,
//            onFridgeClick = onFridgeClick, // onFridgeClick 함수 전달
//            onAddClick = onAddClick,
//            fridgeIcons = fridgeIcons // Add fridgeIcons to SharedHeader
//        )
//
//        // 🔽 기본 냉장고 팝업 (냉장 / 냉동)
//        AnimatedVisibility(visible = isPopupVisible) {
//            FridgePopup(
//                selectedIngredients = selectedIngredients,
//                ingredientsState = ingredientsState,
//                onClose = { isPopupVisible = false } // 팝업 닫기
//            )
//        }
//
//        // 🔽 중간 냉장고 팝업 (냉장 / 냉동)
//        AnimatedVisibility(visible = isMiddlePopupVisible) {
//            MiddleFridgePopup(
//                selectedIngredients = selectedIngredients,
//                ingredientsState = ingredientsState,
//                onClose = { isMiddlePopupVisible = false } // 팝업 닫기
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
//        Box(modifier = Modifier.fillMaxWidth()) {
//            TabRow(
//                selectedTabIndex = selectedTabIndex,
//                modifier = Modifier.fillMaxWidth(),
//                indicator = { /* 필요시 인디케이터 설정 */ }
//            ) {
//                tabs.forEachIndexed { index, title ->
//                    Tab(
//                        selected = selectedTabIndex == index,
//                        onClick = { selectedTabIndex = index },
//                        text = {
//                            Column(
//                                horizontalAlignment = Alignment.CenterHorizontally
//                            ) {
//                                Icon(
//                                    imageVector = icons[index],
//                                    contentDescription = title,
//                                    modifier = Modifier.size(24.dp)
//                                )
//                                Spacer(modifier = Modifier.height(4.dp))
//                                Text(text = title)
//                            }
//                        }
//                    )
//                }
//            }
//        }
//    }
//}
//
//
//@Composable
//fun SharedHeader(
//    isPopupVisible: Boolean,
//    onFridgeClick: (fridgeIcon: @Composable () -> Unit) -> Unit, // 클릭 시 아이콘 정보와 함께 팝업 띄우기
//    onAddClick: () -> Unit,
//    fridgeIcons: MutableList<@Composable () -> Unit> // Add fridgeIcons to SharedHeader
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .height(48.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // fixedFridgeIcon은 @Composable 형태로 정의
//        val fixedFridgeIcon = @Composable {
//            Icon(Icons.Filled.Kitchen, contentDescription = "기본 냉장고")
//        }
//        // 좌측 고정 냉장고 아이콘 (삭제 불가)
//        IconButton(onClick = { onFridgeClick(fixedFridgeIcon) }) {
//            fixedFridgeIcon()
//        }
//
//        // 중간 공간 (수평 스크롤 가능한 추가된 냉장고 아이콘들)
//        Column(modifier = Modifier.weight(1f)) {
//            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//                fridgeIcons.forEach { fridgeIcon ->
//                    IconButton(onClick = { onFridgeClick(fridgeIcon) }) {
//                        fridgeIcon() // 클릭 시 팝업 띄우기
//                    }
//                }
//            }
//        }
//
//        // 우측 + 버튼 고정
//        IconButton(onClick = onAddClick) {
//            Icon(Icons.Default.Add, contentDescription = "추가")
//        }
//    }
//}
//
//@Composable
//fun FridgePopup(
//    selectedIngredients: MutableState<Set<String>>,
//    ingredientsState: MutableState<List<Ingredient>>,
//    onClose: () -> Unit // 팝업 닫기 기능을 위한 파라미터 추가
//) {
//    val fridgeItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉장" }
//    val freezerItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉동" }
//    val roomItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "실온" }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFE0F7FA))
//            .padding(16.dp)
//    ) {
//        // 팝업 닫기 버튼 (상단에 X 표시)
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
//            IconButton(onClick = onClose) {
//                Icon(Icons.Default.Close, contentDescription = "닫기")
//            }
//        }
//
//        // 냉장 아이템
//        Text("냉장", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(fridgeItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                    onClose() // 더블 클릭 시 팝업 닫기
//                })
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        // 냉동 아이템
//        Text("냉동", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(freezerItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                    onClose() // 더블 클릭 시 팝업 닫기
//                })
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        // 실온 아이템
//        Text("실온", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(roomItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                    onClose() // 더블 클릭 시 팝업 닫기
//                })
//            }
//        }
//    }
//}
//
//@Composable
//fun MiddleFridgePopup(
//    selectedIngredients: MutableState<Set<String>>,
//    ingredientsState: MutableState<List<Ingredient>>,
//    onClose: () -> Unit // 팝업 닫기 기능을 위한 파라미터 추가
//) {
//    val fridgeItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉장" }
//    val freezerItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "냉동" }
//    val roomItems = ingredientsState.value.filter { it.name in selectedIngredients.value && it.storage == "실온" }
//
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color(0xFFE0F7FA))
//            .padding(16.dp)
//    ) {
//        // 팝업 닫기 버튼 (상단에 X 표시)
//        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
//            IconButton(onClick = onClose) {
//                Icon(Icons.Default.Close, contentDescription = "닫기")
//            }
//        }
//
//        // 냉장 아이템
//        Text("냉장", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(fridgeItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                    onClose() // 더블 클릭 시 팝업 닫기
//                })
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        // 냉동 아이템
//        Text("냉동", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(freezerItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                    onClose() // 더블 클릭 시 팝업 닫기
//                })
//            }
//        }
//
//        Spacer(Modifier.height(12.dp))
//
//        // 실온 아이템
//        Text("실온", style = MaterialTheme.typography.titleMedium)
//        LazyRow {
//            items(roomItems) { item ->
//                TextBox(text = item.name, onDoubleClick = {
//                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
//                    onClose() // 더블 클릭 시 팝업 닫기
//                })
//            }
//        }
//        Text("이름", style = MaterialTheme.typography.titleMedium)
//    }
//}
//
//@Preview
//@Composable
//fun PreviewSharedHeader() {
//    val fridgeIcons = remember { mutableListOf<@Composable () -> Unit>() }
//
//    // + 버튼 클릭 시 냉장고 아이콘을 추가
//    fridgeIcons.add {
//        Icon(Icons.Filled.Kitchen, contentDescription = "냉장고")
//    }
//
//    SharedHeader(
//        isPopupVisible = false,
//        onFridgeClick = {},
//        onAddClick = {
//            fridgeIcons.add {
//                Icon(Icons.Filled.Kitchen, contentDescription = "냉장고")
//            }
//        },
//        fridgeIcons = fridgeIcons
//    )
//}
//
//
//@Composable
//fun TextBox(text: String, onDoubleClick: () -> Unit) {
//    var lastClickTime by remember { mutableStateOf(0L) }
//    Box(
//        modifier = Modifier
//            .padding(8.dp)
//            .background(Color.White)
//            .border(1.dp, Color.Gray)
//            .clickable {
//                val currentTime = System.currentTimeMillis()
//                if (currentTime - lastClickTime < 300) {
//                    onDoubleClick()
//                }
//                lastClickTime = currentTime
//            }
//            .padding(8.dp)
//    ) {
//        Text(text)
//    }
//}
//
//fun removeIngredientByName(
//    name: String,
//    selectedIngredients: MutableState<Set<String>>,
//    ingredientsState: MutableState<List<Ingredient>>
//) {
//    // ✅ 강제 업데이트 되도록 새 Set 생성
//    selectedIngredients.value = selectedIngredients.value.toMutableSet().apply {
//        remove(name)
//    }.toSet()
//
//    val updated = ingredientsState.value.map {
//        if (it.name == name) it.copy(isChecked = false, expiry = null, count = 1)
//        else it
//    }
//    ingredientsState.value = updated
//}

package com.example.madcampproj1

import com.example.madcampproj1.tab.ListTabContent
import com.example.madcampproj1.tab.GalleryTabContent
import com.example.madcampproj1.tab.FreeTabContent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageButton
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
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.FoodBank
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material.icons.filled.TravelExplore
import com.example.madcampproj1.tab.Ingredient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.ui.viewinterop.AndroidView


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MadCampProj1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainTabs(innerPadding)
                }
            }
        }
    }
}

data class Ingredient(
    val name: String,
    val storage: String,
    var isChecked: Boolean
)

@Composable
fun MainTabs(innerPadding: PaddingValues) {
    val tabs = listOf("식재료", "추천요리", "커뮤니티")
    val icons = listOf(
        Icons.Filled.FoodBank,
        Icons.Filled.MenuBook,
        Icons.Filled.TravelExplore
    )
    var selectedTabIndex by remember { mutableStateOf(0) }
    var isPopupVisible by remember { mutableStateOf(false) }
    var isMiddlePopupVisible by remember { mutableStateOf(false) }

    // 공통 상태
    val selectedIngredients = remember { mutableStateOf(setOf<String>()) }
    val ingredientsState = remember { mutableStateOf<List<Ingredient>>(emptyList()) }
    val isLoaded = remember { mutableStateOf(false) }

    // 냉장고 아이콘 추가 상태
    val fridgeIcons = remember { mutableStateListOf<String>() }
    val fixedFridgeIconId = "fixedFridgeIcon"

    // + 버튼 클릭 시 동작
    val onAddClick = {
        if (selectedTabIndex == 2) {  // tab3에서만 냉장고 아이콘 추가 가능
            fridgeIcons.add("middleFridgeIcon")
        }
    }

    // 냉장고 아이콘 클릭 시 팝업을 띄우는 함수
    val onFridgeClick = { fridgeIconId: String ->
        if (fridgeIconId == fixedFridgeIconId) {
            isPopupVisible = true
            isMiddlePopupVisible = false
        } else {
            isMiddlePopupVisible = true
            isPopupVisible = false
        }
    }

    // 냉장고 아이콘 삭제 함수
    val onDeleteFridgeIcon: (String) -> Unit = { fridgeIconId ->
        fridgeIcons.remove(fridgeIconId)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        // 🧊 상단 아이콘 영역
        SharedHeader(
            isPopupVisible = isPopupVisible,
            onFridgeClick = onFridgeClick, // onFridgeClick 함수 전달
            onAddClick = onAddClick,
            fridgeIcons = fridgeIcons, // Add fridgeIcons to SharedHeader
        )

        // 🔽 기본 냉장고 팝업 (냉장 / 냉동)
        AnimatedVisibility(visible = isPopupVisible) {
            FridgePopup(
                selectedIngredients = selectedIngredients,
                ingredientsState = ingredientsState,
                onClose = { isPopupVisible = false } // 팝업 닫기
            )
        }

        // 🔽 중간 냉장고 팝업 (냉장 / 냉동)
        AnimatedVisibility(visible = isMiddlePopupVisible) {
            MiddleFridgePopup(
                selectedIngredients = selectedIngredients,
                ingredientsState = ingredientsState,
                onClose = { isMiddlePopupVisible = false }, // 팝업 닫기
                fridgeIconId = "middleFridgeIcon", // 중간 냉장고 아이콘의 ID
                onDeleteFridgeIcon = onDeleteFridgeIcon // 삭제 버튼 콜백
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
        Box(modifier = Modifier.fillMaxWidth()) {
            TabRow(
                selectedTabIndex = selectedTabIndex,
                modifier = Modifier.fillMaxWidth(),
                indicator = { /* 필요시 인디케이터 설정 */ }
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTabIndex == index,
                        onClick = { selectedTabIndex = index },
                        text = {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    imageVector = icons[index],
                                    contentDescription = title,
                                    modifier = Modifier.size(24.dp)
                                )
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = title)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun SharedHeader(
    isPopupVisible: Boolean,
    onFridgeClick: (String) -> Unit, // 아이콘 ID를 넘기는 방식
    onAddClick: () -> Unit,
    fridgeIcons: MutableList<String> // Add fridgeIcons to SharedHeader
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(48.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // fixedFridgeIcon은 문자열 형태로 정의
        val fixedFridgeIconId = "fixedFridgeIcon"
        // 좌측 고정 냉장고 아이콘 (고유 ID 전달)
        IconButton(onClick = { onFridgeClick(fixedFridgeIconId) }) {
            Icon(Icons.Filled.Kitchen, contentDescription = "기본 냉장고")
        }

        // 중간 공간 (수평 스크롤 가능한 추가된 냉장고 아이콘들)
        Column(modifier = Modifier.weight(1f)) {
            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                fridgeIcons.forEach { fridgeIconId ->
                    // 냉장고 아이콘을 클릭하면 팝업이 열리도록 함
                    IconButton(onClick = { onFridgeClick(fridgeIconId) }) {
                        Icon(Icons.Filled.Kitchen, contentDescription = "새로운 냉장고")
                    }
                }
            }
        }

        // 우측 + 버튼 고정
        IconButton(onClick = onAddClick) {
            Icon(Icons.Default.Add, contentDescription = "추가")
        }
    }
}

//@Composable
//fun SharedHeader(
//    isPopupVisible: Boolean,
//    onFridgeClick: (String) -> Unit, // 아이콘 ID를 넘기는 방식
//    onAddClick: () -> Unit,
//    fridgeIcons: MutableList<String> // Add fridgeIcons to SharedHeader
//) {
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//            .height(48.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        // fixedFridgeIcon은 문자열 형태로 정의
//        val fixedFridgeIconId = "fixedFridgeIcon"
//        // 좌측 고정 냉장고 아이콘 (고유 ID 전달)
//        IconButton(onClick = { onFridgeClick(fixedFridgeIconId) }) {
//            Icon(Icons.Filled.Kitchen, contentDescription = "기본 냉장고")
//        }
//
//        // 중간 공간 (수평 스크롤 가능한 추가된 냉장고 아이콘들)
//        Column(modifier = Modifier.weight(1f)) {
//            Row(modifier = Modifier.horizontalScroll(rememberScrollState())) {
//                fridgeIcons.forEach { fridgeIconId ->
//                    IconButton(onClick = { onFridgeClick(fridgeIconId) }) {
//                        Icon(Icons.Filled.Kitchen, contentDescription = "새로운 냉장고") // 아이콘 대신 텍스트나 다른 UI 구성 요소를 사용할 수 있음
//                    }
//                }
//            }
//        }
//
//        // 우측 + 버튼 고정
//        IconButton(onClick = onAddClick) {
//            Icon(Icons.Default.Add, contentDescription = "추가")
//        }
//    }
//}

@Composable
fun FridgePopup(
    selectedIngredients: MutableState<Set<String>>,
    ingredientsState: MutableState<List<Ingredient>>,
    onClose: () -> Unit // 팝업 닫기 기능을 위한 파라미터 추가
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
        // 팝업 닫기 버튼 (상단에 X 표시)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            IconButton(onClick = onClose) {
                Icon(Icons.Default.Close, contentDescription = "닫기")
            }
        }

        // 냉장 아이템
        Text("냉장", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(fridgeItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }

        Spacer(Modifier.height(12.dp))

        // 냉동 아이템
        Text("냉동", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(freezerItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }

        Spacer(Modifier.height(12.dp))

        // 실온 아이템
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
fun MiddleFridgePopup(
    selectedIngredients: MutableState<Set<String>>,
    ingredientsState: MutableState<List<Ingredient>>,
    onClose: () -> Unit, // 팝업 닫기 기능을 위한 파라미터 추가
    fridgeIconId: String, // 삭제할 냉장고 아이콘 ID
    onDeleteFridgeIcon: (String) -> Unit // 냉장고 아이콘 삭제 기능
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
        // 팝업 닫기 버튼 (상단에 X 표시)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
            IconButton(onClick = onClose) {
                Icon(Icons.Default.Close, contentDescription = "닫기")
            }
        }

        // 냉장 아이템
        Text("냉장", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(fridgeItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }

        Spacer(Modifier.height(12.dp))

        // 냉동 아이템
        Text("냉동", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(freezerItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }

        Spacer(Modifier.height(12.dp))

        // 실온 아이템
        Text("실온", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(roomItems) { item ->
                TextBox(text = item.name, onDoubleClick = {
                    removeIngredientByName(item.name, selectedIngredients, ingredientsState)
                })
            }
        }

        // 냉장고 삭제 버튼 추가 (MiddleFridgePopup에서만)
        Spacer(Modifier.height(12.dp))
        Button(
            onClick = {
                onDeleteFridgeIcon(fridgeIconId)
                onClose() // 삭제 후 팝업 닫기
            }
        ) {
            Text("냉장고 삭제")
        }
    }
}

//@Composable
//fun TextBox(text: String, onDoubleClick: () -> Unit) {
//    var lastClickTime by remember { mutableStateOf(0L) }
//    Box(
//        modifier = Modifier
//            .padding(8.dp)
//            .background(Color.White)
//            .border(1.dp, Color.Gray)
//            .clickable {
//                val currentTime = System.currentTimeMillis()
//                if (currentTime - lastClickTime < 300) {
//                    onDoubleClick()
//                }
//                lastClickTime = currentTime
//            }
//            .padding(8.dp)
//    ) {
//        Text(text)
//    }
//}
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
