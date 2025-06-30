package com.example.madcampproj1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.madcampproj1.ui.theme.MadCampProj1Theme

import androidx.compose.foundation.Image
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*


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