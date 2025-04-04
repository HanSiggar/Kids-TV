package com.example.androidtvlauncher.utils

import android.content.Context
import android.widget.Toast
import com.example.androidtvlauncher.R
import com.example.androidtvlauncher.repository.AppItem
import com.example.androidtvlauncher.repository.SampleData

fun launchApp(context: Context, app: AppItem) {
    val isApproved = SampleData.approvedApps.any{ it.packageName == app.packageName}
    if(isApproved){
        val launchIntent = context.packageManager.getLaunchIntentForPackage(app.packageName)
        if (launchIntent != null) {
            context.startActivity(launchIntent)
        }
        else{
            Toast.makeText(context, R.string.not_found, Toast.LENGTH_SHORT).show()
        }
    }
    else{
        Toast.makeText(context, R.string.access_denied, Toast.LENGTH_SHORT).show()
    }
}

