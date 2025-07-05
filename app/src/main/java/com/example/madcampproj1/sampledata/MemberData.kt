package com.example.madcampproj1.sampledata

import com.example.madcampproj1.R

import kotlin.random.Random

// 64개 식재료 목록
val ingredientsList = listOf(
    "가지", "깻잎", "대파", "당근", "마늘", "부추", "상추", "애호박", "양배추", "양파", "오이", "쪽파",
    "청양고추 / 일반고추", "토마토", "팽이버섯", "감자", "느타리버섯 / 양송이버섯", "닭가슴살", "닭다리살",
    "대패삼겹 / 대패 목살", "목살", "삼겹살", "소고기", "베이컨", "소시지", "스팸", "계란", "버터", "생크림",
    "우유", "치즈", "두부", "떡", "만두", "멸치육수코인", "부침가루", "순두부", "치킨스톡", "고추장", "된장",
    "간장", "굴소스", "고춧가루", "꿀 / 알룰로스", "마요네즈", "맛술", "물엿", "식초", "참기름", "참치액젓",
    "케첩", "후추", "올리브오일", "참치캔", "밥", "소면", "파스타면", "고등어", "새우", "연어", "김", "김치", "빵"
)

// 무작위로 3개의 재료를 선택하여 Set<String>으로 반환하는 함수
fun getRandomIngredients(): Set<String> {
    return ingredientsList.shuffled().take(3).toSet() // 무작위로 3개 선택
}

object MemberData {
    // MemberDto 목록 생성
    fun getPhoneDataList(): List<MemberDto> {
        return listOf(
            MemberDto(
                1,
                "홍길동",
                37.5665,
                126.9780,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                2,
                "김철수",
                35.1796,
                129.0756,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                3,
                "이영희",
                37.4563,
                126.7052,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                4,
                "박지훈",
                35.1601,
                126.8514,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF33A1",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                5,
                "최수민",
                36.6511,
                127.4894,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#A1FF33",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                6,
                "정유진",
                37.8857,
                127.7299,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                7,
                "오세현",
                34.8825,
                128.6217,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                8,
                "한예진",
                36.5714,
                128.5117,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                9,
                "유다인",
                37.3943,
                129.1226,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                10,
                "강준혁",
                33.5007,
                126.5322,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                11,
                "이소현",
                37.2980,
                127.0384,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                12,
                "김태연",
                35.5331,
                129.3102,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                13,
                "노경민",
                36.3323,
                127.4415,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                14,
                "윤다은",
                38.2034,
                127.0746,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                15,
                "서지민",
                36.8254,
                128.6315,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                16,
                "최민호",
                36.0111,
                129.3753,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                17,
                "정하늘",
                35.1277,
                128.9815,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                18,
                "박소영",
                34.7604,
                127.6622,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                19,
                "김도윤",
                37.4658,
                129.1596,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                20,
                "이준서",
                36.8020,
                127.1333,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                21,
                "조유나",
                36.7188,
                127.1489,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                22,
                "권정우",
                38.3204,
                127.4176,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                23,
                "한지훈",
                37.0410,
                127.7481,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                24,
                "김수정",
                37.4803,
                126.8816,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                25,
                "오다영",
                35.8151,
                128.5745,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                26,
                "이채은",
                36.3491,
                127.4337,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                27,
                "박민준",
                35.9857,
                128.6226,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                28,
                "정유빈",
                37.8472,
                126.8915,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#FF5733",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                29,
                "최서연",
                36.7172,
                126.8427,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#33FF57",  // 이미지 색상
                getRandomIngredients()
            ),
            MemberDto(
                30,
                "김태우",
                37.6497,
                126.9694,
                R.drawable.kitchen,  // 이미지 리소스 ID
                R.drawable.kitchen,  // 원형 이미지 리소스 ID
                "#5733FF",  // 이미지 색상
                getRandomIngredients()
            )
        )
    }
}
