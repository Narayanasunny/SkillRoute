plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.skillroute"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.skillroute"
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

    // ✅ Enable ViewBinding
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // AndroidX core + appcompat
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)

    implementation ("androidx.cardview:cardview:1.0.0")





    // Layout + Activity support
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.activity)

    // ViewPager2 for onboarding screens

    // ✅ ViewPager2 and Material Design
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    implementation("com.google.android.material:material:1.9.0")


    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //for feedbackpage
    implementation ("nl.dionsegijn:konfetti-xml:2.0.2")
    implementation ("com.airbnb.android:lottie:6.1.0")

    implementation ("com.google.android.material:material:1.11.0")



}
