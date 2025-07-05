package com.example.madcampproj1.tab
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


// ✅ Compose
//import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
//import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner

// ✅ Android SDK
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.VectorDrawable
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView

// ✅ Naver Map
import com.naver.maps.map.MapView
import com.naver.maps.map.NaverMap
import com.naver.maps.map.CameraAnimation
import com.naver.maps.map.CameraUpdate
import com.naver.maps.map.overlay.Marker
import com.naver.maps.map.overlay.OverlayImage
import com.naver.maps.geometry.LatLng

// ✅ 프로젝트 데이터
import com.example.madcampproj1.R
import com.example.madcampproj1.sampledata.MemberData
import com.example.madcampproj1.sampledata.MemberDto
import com.example.madcampproj1.sampledata.CVData

@Composable
fun FreeTabContent() {
    val context = LocalContext.current
    val mapView = rememberMapViewWithLifecycle()

    AndroidView(
        factory = { mapView },
        modifier = Modifier.fillMaxSize()
    ) { mapView ->
        mapView.getMapAsync { naverMap ->
            val memberList = MemberData.getPhoneDataList()

            memberList.forEach { member ->
                val markerView = createCustomMarkerView(context, member)
                val bitmap = createBitmapFromView(markerView)
                Marker().apply {
                    icon = OverlayImage.fromBitmap(bitmap)
                    position = LatLng(member.lat, member.lng)
                    map = naverMap
                    setOnClickListener {
                        context.startActivity(Intent(Intent.ACTION_DIAL).apply {
                            data = Uri.parse("tel:${member.imgColor}")
                        })
                        true
                    }
                }
            }

            // 초기 카메라 위치
            val initialLocation = LatLng(37.5665, 126.9780)
            val cameraUpdate = CameraUpdate.scrollTo(initialLocation)
                .animate(CameraAnimation.Easing)
            naverMap.moveCamera(cameraUpdate)
        }
    }
}

//fun createCustomMarkerView(context: Context, member: MemberDto): View {
//    val view = LayoutInflater.from(context).inflate(R.layout.map_pin, null)
//    val imageView: ImageView = view.findViewById(R.id.phone_component_image)
//    val nameText: TextView = view.findViewById(R.id.phone_component_name)
//    val statusText: TextView = view.findViewById(R.id.phone_component_status)
//    val cardView: CardView = view.findViewById(R.id.phone)
//
//    val cv = CVData.getCVDataList().find { it.memberId == member.memberId }
//    cv?.let {
//        imageView.setImageResource(member.imgCirclePath)
//        imageView.setBackgroundResource(R.drawable.circle)
//        cardView.radius = 50f
//        nameText.text = member.name
//        statusText.text = it.qualification
//    }
//    return view
//}

fun createCustomMarkerView(context: Context, member: MemberDto): View {
    val view = LayoutInflater.from(context).inflate(R.layout.map_pin, null)
    val imageView: ImageView = view.findViewById(R.id.phone_component_image)
    val nameText: TextView = view.findViewById(R.id.phone_component_name)
    val statusText: TextView = view.findViewById(R.id.phone_component_status)
    val cardView: CardView = view.findViewById(R.id.phone)

    // CVData에서 멤버 정보를 가져오기
    val cv = CVData.getCVDataList().find { it.memberId == member.memberId }
    cv?.let {
        // 원형 아이콘 이미지 설정
        imageView.setImageResource(member.imgCirclePath) // 기본 원형 이미지 설정
        imageView.setBackgroundResource(R.drawable.circle) // 원형 배경 설정
        cardView.radius = 50f // 카드뷰의 반지름 설정

        // 이름과 상태 텍스트 설정
        nameText.text = member.name
        statusText.text = it.qualification

        // 이미지 색상 동적으로 변경
        val color = member.imgColor  // 예를 들어 member.imgColor는 "#FF5733" 형식입니다.
        updateIconColorUsingColorFilter(imageView, color)  // 동적으로 색상 변경
    }
    return view
}

fun updateIconColorUsingColorFilter(imageView: ImageView, color: String) {
    // 색상 파싱 (잘못된 색상 입력을 처리)
    val parsedColor = try {
        Color.parseColor(color) // "#RRGGBB" 형식의 색상 문자열을 Color 객체로 변환
    } catch (e: IllegalArgumentException) {
        Color.GRAY // 잘못된 색상 값일 경우 기본 색상
    }

    // ColorFilter를 사용하여 색상 변경
    imageView.setColorFilter(parsedColor) // ImageView에 색상 필터 적용
}



fun createBitmapFromView(view: View): Bitmap {
    view.measure(
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
        View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
    )
    view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    val bitmap = Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
    val canvas = Canvas(bitmap)
    view.draw(canvas)
    return bitmap
}


@Composable
fun rememberMapViewWithLifecycle(): MapView {
    val context = LocalContext.current
    val mapView = remember { MapView(context) }

    val lifecycle = LocalLifecycleOwner.current.lifecycle
    DisposableEffect(lifecycle, mapView) {
        val observer = LifecycleEventObserver { _, event ->
            when (event) {
                Lifecycle.Event.ON_CREATE -> mapView.onCreate(null)
                Lifecycle.Event.ON_START -> mapView.onStart()
                Lifecycle.Event.ON_RESUME -> mapView.onResume()
                Lifecycle.Event.ON_PAUSE -> mapView.onPause()
                Lifecycle.Event.ON_STOP -> mapView.onStop()
                Lifecycle.Event.ON_DESTROY -> mapView.onDestroy()
                else -> {}
            }
        }
        lifecycle.addObserver(observer)
        onDispose { lifecycle.removeObserver(observer) }
    }
    return mapView
}