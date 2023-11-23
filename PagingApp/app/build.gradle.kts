plugins {
    id("com.android.application")

}



android {
    namespace = "com.example.pagingapp"
    compileSdk = 32

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.example.pagingapp"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.google.code.gson:gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    // RxJava3 with retrofit
    implementation ("com.squareup.retrofit2:adapter-rxjava3:2.9.0")

    // Paging Library

    implementation ("androidx.paging:paging-runtime:3.1.1")
    // optional - RxJava3 support
    implementation ("androidx.paging:paging-rxjava3:3.1.1")

    // Hilt Dagger
    implementation ("com.google.dagger:hilt-android:2.41")
    annotationProcessor ("com.google.dagger:hilt-compiler:2.41")

    // Glide
    implementation ("com.github.bumptech.glide:glide:4.13.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.13.0")


    // LIfeCycle

    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel:2.5.0-alpha04")
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.0-alpha04")

}