


// Mendaftarkan plugin yang dibutuhkan untuk membangun
// aplikasi Android dan mengaktifkan dukungan bahasa Kotlin.
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

// Mengatur konfigurasi utama Android seperti namespace,
// SDK yang digunakan, identitas aplikasi, dan konfigurasi build.
android {
    namespace = "com.example.mobileadvapp"

    // SDK yang digunakan untuk proses kompilasi aplikasi.
    compileSdk = 35

    // Mengatur identitas aplikasi, SDK minimum,
// SDK target, serta versi aplikasi.
    defaultConfig {
        applicationId = "com.example.mobileadvapp"

        // Android minimum yang didukung aplikasi.
        minSdk = 26

        // Versi Android yang menjadi target aplikasi.
        //noinspection ExpiredTargetSdkVersion
        targetSdk = 35

        // Informasi versi aplikasi.
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner =
            "androidx.test.runner.AndroidJUnitRunner"
    }

    // Mengatur konfigurasi build untuk versi release.
    buildTypes {
        release {
            isMinifyEnabled = false

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    // Mengatur kompatibilitas Java yang digunakan project.
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    // Mengatur target JVM untuk Kotlin.
    kotlinOptions {
        jvmTarget = "17"
    }

    // Mengaktifkan ViewBinding agar komponen pada layout XML
    // dapat diakses melalui class binding tanpa findViewById().
    buildFeatures {
        viewBinding = true
    }
}

// Mendefinisikan library eksternal yang dibutuhkan
// oleh aplikasi Android dan library untuk testing.
dependencies {

        // Library dasar AndroidX.
        implementation("androidx.core:core-ktx:1.15.0")

        // AppCompat untuk Activity berbasis View/XML.
        implementation("androidx.appcompat:appcompat:1.7.0")

        // Material Design untuk komponen UI Android.
        implementation("com.google.android.material:material:1.12.0")

        // Android Activity.
        implementation("androidx.activity:activity-ktx:1.10.0")

        // ConstraintLayout.
        implementation("androidx.constraintlayout:constraintlayout:2.2.0")

        // Unit Testing.
        testImplementation("junit:junit:4.13.2")

        // Instrumentation Testing.
        androidTestImplementation("androidx.test.ext:junit:1.2.1")
        androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    }

