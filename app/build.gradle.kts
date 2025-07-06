plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.madcampproj1"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.madcampproj1"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    // 임시
    lint {
        checkReleaseBuilds = false
        abortOnError = false
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.recyclerview)
    implementation(libs.material)
    implementation(libs.play.services.maps)
    implementation(libs.androidx.legacy.support.v4)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("androidx.compose.material:material-icons-extended")

// ✅ Naver Map SDK
//    implementation("com.naver.maps:map-sdk:3.17.0")
//    implementation("com.naver.maps:map-sdk:3.20.0")
    implementation("com.naver.maps:map-sdk:3.22.0")

// ✅ Compose에서 Android View를 사용할 수 있게 해주는 Interop 라이브러리
    implementation("androidx.compose.ui:ui-viewbinding:1.6.0")

// ✅ Lifecycle Compose 연동 (rememberMapViewWithLifecycle 사용 시 필요)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")

    implementation("androidx.cardview:cardview:1.0.0")

    // build.gradle(:app) 파일에 추가 (Compose 버전에 맞춰 버전 조정 가능)
    // implementation("com.google.accompanist:accompanist-pager:0.32.0")
//    implementation("com.google.accompanist:accompanist-pager:0.27.1")
//    implementation("com.google.accompanist:accompanist-pager-indicators:0.32.0") // 선택사항
//    implementation("androidx.compose.material:material:1.6.1")
}