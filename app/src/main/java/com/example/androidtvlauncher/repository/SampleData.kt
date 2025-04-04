package com.example.androidtvlauncher.repository

data class AppItem(val name: String, val packageName: String)

object SampleData {
    val allApps = listOf(
        AppItem("YouTube", "com.google.android.youtube"),
        AppItem("Netflix", "com.netflix.mediaclient"),
        AppItem("Disney+", "com.disney.disneyplus"),
        AppItem("Prime Video", "com.amazon.avod.thirdpartyclient"),
        AppItem("Gallery", "com.android.gallery"),
        AppItem("Calculator", "com.android.calculator2"),
        AppItem("Chrome", "com.android.chrome"),
        AppItem("Settings", "com.android.settings")
    )

    val approvedApps = allApps.filterNot { it.packageName in listOf("com.android.settings", "com.android.chrome") }
}