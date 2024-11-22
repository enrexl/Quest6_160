package com.example.week8_navigationmultipledata.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.week8_navigationmultipledata.R
import java.nio.file.WatchEvent

@Preview
@Composable
fun SplashView(
    onMulaiButtonClicked: () -> Unit
){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.Primary)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){


        Image(painter = painterResource(R.drawable.logo),
            contentDescription = "",
            modifier = Modifier.size(150.dp))

        Button(onClick = {onMulaiButtonClicked()},
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp))
        {
            Text("Mulai")
                }
    }

}

