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
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MadCampProj1Theme {
        Greeting("Android")
    }
}

data class Message(val auth: String, val body: String)

// Column, Row, Box 를 사용할 수 있음
@Composable
fun MessageCard(mSg: Message) {
Row {
    Image(
        painter = painterResource(id=R.drawable.image1),
        contentDescription = "profile image",
        modifier = Modifier
            .size(120.dp),  // 가로, 세로 모두 120dp로 설정
        contentScale = ContentScale.Fit,  // 잘리지 않고 맞게 축소됨
    )
    
    // image 와 작성자 정보 사이에 공란 추가
    Spacer(modifier = Modifier.width(8.dp))

    Column {
        Text(text = mSg.auth)
        Text(text = mSg.body)
    }
}

}

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(mSg = Message("someone", "My First Jetpack Compose"))
}

////@OptIn(ExperimentalFoundationApi::class)
//@Composable
//fun MainTabs() {
//    val tabs = listOf("리스트", "갤러리", "자유")
//    val pagerState = rememberPagerState(pageCount = {tabs.size})
//    val coroutineScope = rememberCoroutineScope()
//    Column {
//        Spacer(modifier = Modifier.height(24.dp)) // ← 상단에 여백 추가
//        TabRow(
//            selectedTabIndex = pagerState.currentPage,
////            indicator = { tabPositions ->
////                TabRowDefaults.SecondaryIndicator(
////                    Modifier
////                        .tabIndicatorOffset(tabPositions[pagerState.currentPage]),
////                    color = MaterialTheme.colorScheme.primary
////                )
////            }
//        ) {
//            tabs.forEachIndexed { index, title ->
//                Tab(
//                    text = { Text(title) },
//                    selected = pagerState.currentPage == index,
//                    onClick = {
//                        coroutineScope.launch {
//                            pagerState.animateScrollToPage(index)
//                        }
//                    }
//                )
//            }
//        }
//
//        HorizontalPager(
////            count = tabs.size, // ✅ 여기가 핵심!
//            state = pagerState,
//            modifier = Modifier.fillMaxSize()
//        ) { page ->
//            when (page) {
//                0 -> ListTabContent()
//                1 -> GalleryTabContent()
//                2 -> FreeTabContent()
//            }
//        }
//    }
//}

//@Composable
//fun MainTabs(innerPadding: PaddingValues) {
//    val tabs = listOf("리스트", "갤러리", "자유")
//    var selectedTabIndex by remember { mutableStateOf(0) }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
////            .padding(bottom = 16.dp) // 👈 하단 공간 확보
//            .padding(innerPadding)
//    ) {
//
//        // ✅ 공유되는 상단 영역
//        SharedHeader()
////        Spacer(modifier = Modifier.height(0.dp)) // 상단 여백
//        // 🔼 콘텐츠 먼저 보여줌
//        Box(modifier = Modifier.weight(1f)) {
//            when (selectedTabIndex) {
//                0 -> ListTabContent()
//                1 -> GalleryTabContent()
//                2 -> FreeTabContent()
//            }
//        }
//
//        // 🔽 TabRow를 하단에 배치
//        TabRow(
//            selectedTabIndex = selectedTabIndex,
//            modifier = Modifier.fillMaxWidth()
////            .navigationBarsPadding() // 👈 또는 이걸 써서 안전 영역 자동 적용
//        ) {
//            tabs.forEachIndexed { index, title ->
//                Tab(
//                    text = { Text(title) },
//                    selected = selectedTabIndex == index,
//                    onClick = {
//                        selectedTabIndex = index
//                    }
//                )
//            }
//        }
//    }
//}

//@Composable
//fun SharedHeader() {
//    // 원하는 공통 UI 넣기
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .background(Color.LightGray)
//            .padding(16.dp)
//    ) {
//        Text("🧊 냉장고를 부탁해", style = MaterialTheme.typography.titleMedium)
//        Text("공유된 영역입니다.", style = MaterialTheme.typography.bodySmall)
//    }
//}

//fun Modifier.tabIndicatorOffset(
//    currentTabPosition: TabPosition
//): Modifier = composed(
//    inspectorInfo = debugInspectorInfo {
//        name = "tabIndicatorOffset"
//        value = currentTabPosition
//    }
//) {
//    val currentTabWidth by animateDpAsState(
//        targetValue = currentTabPosition.width,
//        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
//        label = ""
//    )
//    val indicatorOffset by animateDpAsState(
//        targetValue = currentTabPosition.left,
//        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
//        label = ""
//    )
//    fillMaxWidth()
//        .wrapContentSize(Alignment.BottomStart)
//        .offset { IntOffset(indicatorOffset.roundToPx(), 0) }
//        .width(currentTabWidth)
//}

@Composable
fun MainTabs(innerPadding: PaddingValues) {
    val tabs = listOf("리스트", "갤러리", "자유")
    var selectedTabIndex by remember { mutableStateOf(0) }
    var isPopupVisible by remember { mutableStateOf(false) }

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

        // 🔽 팝업 (냉장/냉동)
        AnimatedVisibility(visible = isPopupVisible) {
            FridgePopup()
        }

        // ✅ 콘텐츠 (리스트/갤러리/자유)
        Box(modifier = Modifier.weight(1f)) {
            when (selectedTabIndex) {
                0 -> ListTabContent()
                1 -> GalleryTabContent()
                2 -> FreeTabContent()
            }
        }

        // 🔽 하단 탭
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

@Composable
fun FridgePopup() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE0F7FA))
            .padding(16.dp)
    ) {
        Text("냉장", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(listOf("계란", "우유", "버터")) { item ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.White)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                ) {
                    Text(item)
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Text("냉동", style = MaterialTheme.typography.titleMedium)
        LazyRow {
            items(listOf("만두", "떡", "닭가슴살")) { item ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .background(Color.White)
                        .border(1.dp, Color.Gray)
                        .padding(8.dp)
                ) {
                    Text(item)
                }
            }
        }
    }
}
