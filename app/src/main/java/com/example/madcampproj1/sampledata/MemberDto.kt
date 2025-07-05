package com.example.madcampproj1.sampledata

//data class MemberDto(
//    val memberId : Int,
//    val name: String,
//    val phone: String,
//    val email: String,
//    val lat : Double,    //위도
//    val lng : Double,    //경도
//    val imgPath: Int,
//    val imgCirclePath: Int,
//    val major: String,
//    val minor: String,
//    val birth: String,
//    val home: String
//)

data class MemberDto(
    val memberId: Int,
    val name: String,
    val lat: Double,    // 위도
    val lng: Double,    // 경도
    val imgPath: Int,    // 이미지 파일 이름 (String으로 정의)
    val imgCirclePath: Int,  // 이미지 원형 파일 이름 (String으로 정의)
    val imgColor: String,  // 이미지 색상 (String으로 정의)
    val ingredients: Set<String>  // 재료 목록 (Set<String>)
)

