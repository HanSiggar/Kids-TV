package com.example.androidtvlauncher.ui.main


import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidtvlauncher.R
import com.example.androidtvlauncher.repository.SampleData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController, context: Context){

    val approvedApps by remember { mutableStateOf(SampleData.approvedApps) }

    BackHandler {
        navController.navigate("pinScreen")
    }
    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(
                    text = stringResource(R.string.title),
                    color = Color.White
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.DarkGray
            )
            )
        },
        containerColor = Color.Black
    ){
        padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ){
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),  //items per row
                    modifier = Modifier
                        .fillMaxSize(1f)
                        .padding(16.dp)
                ) {
                    items(SampleData.allApps) { app ->
                        AppItemCard(app, context)
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    contentAlignment = Alignment.Center
                ){
                    Button(
                        onClick = { navController.navigate("pinScreen") },
                        modifier = Modifier
                            .padding(16.dp)
                            .focusable()
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red,
                            contentColor = Color.White
                        )
                    ) {
                        Text(
                            text = stringResource(R.string.exit),
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }

    }
}