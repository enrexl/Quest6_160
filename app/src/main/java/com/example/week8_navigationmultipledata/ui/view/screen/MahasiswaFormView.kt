package com.example.week8_navigationmultipledata.ui.view.screen

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import com.example.week8_navigationmultipledata.ui.view.viewmodel.MahasiswaViewModel
import com.example.week8_navigationmultipledata.R
import java.nio.file.WatchEvent

@Preview(showBackground = true)
@Composable
fun MahasiswaFormView(
    onSubmitButtonClicked:(MutableList<String>)-> Unit,
    onBackButtonCLicked: ()-> Unit,
){

    var nama by remember { mutableStateOf("") }
    var nim by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(nim,nama,email)


    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = colorResource(id = R.color.Primary)),
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )

            Column(modifier = Modifier.padding(5.dp)) {
                Text(
                    text = "Universitas Muhammadiyah Yogyakarta",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Unggul dan Islami",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Light
                )

            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 20.dp,
                        topStart = 20.dp
                    )
                )
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Masukkan Data Kamu",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Isi Sesuai Data yang kamu Daftarkan",
                    fontWeight = FontWeight.Light
                )

                OutlinedTextField(
                    onValueChange = { nim = it },
                    value = nim,
                    label = {Text(text = "NIM")},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = ""
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp)
                )

                OutlinedTextField(
                    onValueChange = { nama = it },
                    value = nama,
                    label = {Text(text = "Nama")},
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = ""
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp)
                )
                OutlinedTextField(
                    onValueChange = { email = it },
                    value = email,
                    label = {Text(text = "Email")},
                    placeholder = { Text("Masukan Email Anda") },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Info,
                            contentDescription = ""
                        )
                    },
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(20.dp)
                )


//

                Spacer(modifier = Modifier.padding(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                )
                {

                    Button(onClick = {onBackButtonCLicked()})
                    {
                        Text("BACK")
                    }

                    //Button(onClick =){onSubmitButtonClicked(listData)})
                    Button(onClick ={onSubmitButtonClicked(listData)})
                    {
                        Text("NEXT")
                    }
                }
            }
        }
    }
}
