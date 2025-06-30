package com.example.madcampproj1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.debugInspectorInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.madcampproj1.ui.theme.MadCampProj1Theme
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MadCampProj1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                    MainTabs()
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
        painter = painterResource(id=R.drawable.my_image),
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

//@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainTabs() {
    val tabs = listOf("리스트", "갤러리", "자유")
    val pagerState = rememberPagerState(pageCount = {tabs.size})
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
//            indicator = { tabPositions ->
//                TabRowDefaults.SecondaryIndicator(
//                    Modifier
//                        .tabIndicatorOffset(tabPositions[pagerState.currentPage]),
//                    color = MaterialTheme.colorScheme.primary
//                )
//            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = pagerState.currentPage == index,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
//            count = tabs.size, // ✅ 여기가 핵심!
            state = pagerState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> ListTabContent()
                1 -> GalleryTabContent()
                2 -> FreeTabContent()
            }
        }
    }
}
@Composable
fun ListTabContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("여기에 이미지 갤러리 표시")
    }
}

@Composable
fun GalleryTabContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("여기에 이미지 갤러리 표시")
    }
}

@Composable
fun FreeTabContent() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("자유 주제 탭입니다")
    }
}

fun Modifier.tabIndicatorOffset(
    currentTabPosition: TabPosition
): Modifier = composed(
    inspectorInfo = debugInspectorInfo {
        name = "tabIndicatorOffset"
        value = currentTabPosition
    }
) {
    val currentTabWidth by animateDpAsState(
        targetValue = currentTabPosition.width,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        label = ""
    )
    val indicatorOffset by animateDpAsState(
        targetValue = currentTabPosition.left,
        animationSpec = tween(durationMillis = 250, easing = FastOutSlowInEasing),
        label = ""
    )
    fillMaxWidth()
        .wrapContentSize(Alignment.BottomStart)
        .offset { IntOffset(indicatorOffset.roundToPx(), 0) }
        .width(currentTabWidth)
}