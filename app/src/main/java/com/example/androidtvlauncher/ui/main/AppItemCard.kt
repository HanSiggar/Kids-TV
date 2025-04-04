package com.example.androidtvlauncher.ui.main

import android.content.Context
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.focusTarget
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidtvlauncher.repository.AppItem
import com.example.androidtvlauncher.repository.SampleData
import com.example.androidtvlauncher.utils.launchApp
import kotlinx.coroutines.delay

@Composable
fun AppItemCard(app: AppItem, context: Context) {

    val focusRequester = remember { FocusRequester() }
    var isFocused by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if(isFocused) 1.1f else 1f,
        animationSpec = tween(durationMillis = 200)
    )

    val isApproved = app in SampleData.approvedApps
    val borderColor = when {
        isFocused && isApproved -> Color.Yellow
        isFocused && !isApproved -> Color.Red
        else -> Color.Transparent
    }

    LaunchedEffect(Unit) {
        delay(200)
        focusRequester.requestFocus()
    }

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .padding(10.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
                println("Focus changed: $isFocused for ${app.name}") // Debugging log
            }

            .focusRequester(focusRequester)
            .focusable()         // added D Pad Keys for navigation.
            .onFocusEvent { isFocused = it.isFocused }
            .border(
                width = if(isFocused) 4.dp else 0.dp,
                color = borderColor,
                shape = RoundedCornerShape(12.dp)
            )
            .clickable { launchApp(context, app) },
        colors = CardDefaults.cardColors(
            containerColor = Color.Gray,
            contentColor = Color.White
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = app.name,
                style = MaterialTheme.typography.bodyMedium,
                color = if (isFocused) Color.Yellow else Color.White,
                modifier = Modifier.padding(8.dp),
                fontSize = 18.sp
            )
        }
    }
}

