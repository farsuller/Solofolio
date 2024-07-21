import java.io.FileNotFoundException
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

val keystoreProperties: Properties by lazy {
    val properties = Properties()
    val keystorePropertiesFile = rootProject.file("keystore.properties")

    if (keystorePropertiesFile.exists()) {
        properties.load(keystorePropertiesFile.inputStream())
    } else {
        throw FileNotFoundException("Keystore properties file not found.")
    }

    properties
}

android {
    namespace = ProjectConfig.NAMESPACE

    defaultConfig {
        applicationId = ProjectConfig.APPLICATION_ID
        versionCode = ProjectConfig.VERSION_CODE
        versionName = "${ProjectConfig.MAJOR_VERSION}.${ProjectConfig.MINOR_VERSION}.${ProjectConfig.PATCH_VERSION}"

    }

    applicationVariants.all {
        base.archivesName.set("${ProjectConfig.APP_FILENAME}-${buildType.name}-$versionCode-$versionName")
    }


    signingConfigs {
        register("release") {
            storeFile = file("keystore/portfoliofs.jks")
            storePassword = keystoreProperties["storePasswordOld"].toString()
            keyAlias = keystoreProperties["keyAliasOld"].toString()
            keyPassword = keystoreProperties["keyPasswordOld"].toString()
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.getByName("debug")
            isDebuggable = true
            isMinifyEnabled = false
        }

        release {
            signingConfig = signingConfigs.getByName("release")
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(platform(libs.compose.bom))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose.v182)
    implementation(libs.androidx.core.splashscreen)

    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.coil.kt.compose)

    implementation(libs.orbital)
    implementation(libs.androidx.animation)
    implementation(libs.androidx.foundation.layout)

    implementation(libs.kotlinx.serialization.json)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    implementation(libs.bundles.app.updates)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}