plugins {
    // TODO 1: ADD KSP PLUGIN
    id("com.google.devtools.ksp")

    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // TODO 15: ADD PARCELABLE PLUGIN
    id("kotlin-parcelize")
}

android {
    namespace = "com.asiah.quranapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.asiah.quranapp"
        minSdk = 33
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    // TODO 2: ADD BUILD FEATURES VIEWBINDING
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // TODO 3: IMPLEMENT MOSHI LIBRARY(DON'T FORGET TO CHANGES KOTLIN OPTIONS)
    implementation("com.squareup.moshi:moshi:1.14.0")
    ksp("com.squareup.moshi:moshi-kotlin-codegen:1.14.0") // for KSP
    
    // TODO 4: IMPLEMENT NAVIGATION LIBRARY
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.5")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.5")

    // TODO 5: IMPLEMENT RETROFIT FOR CONVERTER DATA & LOGGING INTERCEPTOR FOR HANDLING LOG
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

    // TODO 19: IMPLEMENT FUSEDLOCATION, COROUTINE, LIVE DATA
    //FusedLocation
    implementation("com.google.android.gms:play-services-location:21.0.1")
    //coroutine
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    //LiveData
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")


    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}