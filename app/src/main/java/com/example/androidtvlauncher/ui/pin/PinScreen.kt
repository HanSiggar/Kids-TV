package com.example.androidtvlauncher.ui.pin

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.androidtvlauncher.R

@Composable
fun PinScreen(navController: NavController){
    var pin by remember { mutableStateOf("") }
    val correctPin = "1234"
    var showError by remember { mutableStateOf(false) } //for showing error if wrong pin is entered

    BackHandler { //prevents back navigation(block back button)

    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.enter_pin),
            color = Color.White,
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.DarkGray,
                unfocusedLabelColor = Color.Black,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.Gray
            ),
            modifier = Modifier.background(Color.DarkGray),
            value = pin,
            onValueChange = {
                if(it.length <= 4) {
                pin = it
                showError = false }},
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            singleLine = true,
            isError = showError,
            textStyle = TextStyle(color = Color.White)
        )

        if (showError){
            Text(
                text = stringResource(R.string.wrong_pin),
                color = Color.Red
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            if(pin == correctPin){
                navController.navigate("homeScreen"){
                    popUpTo("pinScreen"){ inclusive = true}
                } //exit will be allowed
            }
            else{
                pin = "" //will reset pin
                showError = true
            }
        }) {
            Text(
                text = stringResource(R.string.submit)
            )
        }
    }
}