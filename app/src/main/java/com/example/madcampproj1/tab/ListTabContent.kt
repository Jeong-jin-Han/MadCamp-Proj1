package com.example.madcampproj1.tab

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.material3.HorizontalDivider

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

@Composable
fun ListTabContent() {
    val itemList = listOf(
        "사과", "바나나", "체리", "딸기", "수박", "포도", "복숭아", "레몬"
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp) // ← 여기가 핵심!
    ) {
        items(itemList) { item ->
            Column {
                Text(
                    text = item,
                    style = MaterialTheme.typography.bodyLarge
                )
                HorizontalDivider()
            }
        }
    }
}
