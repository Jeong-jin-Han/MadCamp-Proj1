package com.example.madcampproj1.tab
//import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.*
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
//import com.example.madcampproj1.R
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.remember

//@Composable
//fun GalleryTabContent() {
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Text("여기에 이미지 갤러리 표시")
//    }
//}
@Suppress("DiscouragedApi")
@Composable
fun GalleryTabContent() {
    val context = LocalContext.current

    // 자동으로 image1 ~ image20 불러오기
    val imageIds = remember {
        (1..21).mapNotNull { index ->
            val name = "image$index"
            val resId = context.resources.getIdentifier(name, "drawable", context.packageName)
            if (resId != 0) resId else null
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(imageIds.size) { index ->
            Image(
                painter = painterResource(id = imageIds[index]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            )
        }
    }
}
