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

@Suppress("DiscouragedApi")
@Composable
fun GalleryTabContent() {
    val context = LocalContext.current

    // 🔁 이미지 ID 리스트
    val imageIds = remember {
        (1..21).mapNotNull { index ->
            val name = "image$index"
            val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
            if (resId != 0) resId else null
        }
    }

    // 🌟 상태: 선택된 이미지 인덱스 (기존 selectedImageId → index 기반으로 변경)
    var selectedImageIndex by remember { mutableStateOf<Int?>(null) }

    if (selectedImageIndex != null) {
        val pagerState = rememberPagerState(
            pageCount = { imageIds.size }
        )

        // 이미지 선택되었을 때 해당 index로 스크롤 이동
        LaunchedEffect(selectedImageIndex) {
            pagerState.scrollToPage(selectedImageIndex!!)
        }

        // 🔍 전체 화면 슬라이드 보기
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable { selectedImageIndex = null }, // 클릭 시 전체 보기 종료
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                HorizontalPager(
                    state = pagerState,
                    modifier = Modifier.fillMaxWidth()
                ) { page ->
                    Image(
                        painter = painterResource(id = imageIds[page]),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "이미지: image${pagerState.currentPage + 1}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    } else {
        // 📸 일반 갤러리 그리드 뷰
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(bottom = 80.dp)
        ) {
            items(imageIds.size) { index ->
                Image(
                    painter = painterResource(id = imageIds[index]),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clickable {
                            selectedImageIndex = index // 클릭 시 전체 화면 모드 진입
                        }
                )
            }
        }
    }
}