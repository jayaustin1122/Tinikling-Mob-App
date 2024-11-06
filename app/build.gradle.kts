plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.tinikling.com"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.tinikling.com"
        minSdk = 24
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    val roomVersion = "2.6.0"
    implementation("androidx.room:room-ktx:$roomVersion")
    kapt("androidx.room:room-compiler:$roomVersion")
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation ("com.google.android.exoplayer:exoplayer:2.18.1")
    implementation ("com.google.android.exoplayer:exoplayer-core:2.17.1")
    implementation ("com.google.android.exoplayer:exoplayer-ui:2.17.1")
    val nav_version = "2.7.2"
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
    implementation ("androidx.fragment:fragment-ktx:1.8.1")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    //circular
    implementation ("pl.droidsonroids.gif:android-gif-drawable:1.2.27")
    // dependency for circular ImageView
    implementation ("de.hdodenhof:circleimageview:3.1.0")
    //karumi to access other component of mobile
    implementation ("com.karumi:dexter:6.2.2")
    implementation ("com.itextpdf:kernel:7.1.15")
    implementation ("com.itextpdf:layout:7.1.15")
    //glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.14.2")
    //coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    //Retrofit
    implementation ("com.squareup.retrofit2:converter-gson:2.6.0")
    implementation ("pub.devrel:easypermissions:3.0.0")
    implementation( "androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")
    implementation ("com.squareup.picasso:picasso:2.8")
    implementation ("com.google.code.gson:gson:2.8.8")
}