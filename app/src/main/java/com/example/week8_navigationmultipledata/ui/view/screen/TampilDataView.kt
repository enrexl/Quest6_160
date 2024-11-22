package com.example.week8_navigationmultipledata.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.week8_navigationmultipledata.R
import com.example.week8_navigationmultipledata.model.Mahasiswa
import com.example.week8_navigationmultipledata.model.RencanaStudi

@Preview
@Composable
fun TampilDataView(
    modifier: Modifier = Modifier,
    mhs : Mahasiswa,
    mk : RencanaStudi,
    onBackButtonClicked:()-> Unit,
    onSubmitButtonClicked:()-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(id = R.color.Primary))
    ) {
        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )

            Spacer(modifier = Modifier.padding(start = 16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = mhs.nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.White
                )
                Text(
                    text = mhs.nim,
                    fontWeight = FontWeight.Bold,
                    fontSize = 12.sp,
                    color = Color.White
                )

            }

            Box {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "",
                    tint = Color.White
                )
            }

        }
        Box(
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topEnd = 20.dp,
                        topStart = 20.dp
                    )
                )
                .fillMaxSize()
        )
        {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(25.dp),


            ) {
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "Data Mahasiswa",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,

                )}
                HorizontalDivider()

                Column() {
                    Text(text = "Informasi Mahasiswa", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "NIM: " + mhs.nim)
                    Text(text = "Nama: " + mhs.nama)
                    Text(text = "Email: " + mhs.email)
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(text = "Rencana Studi", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "Mata Kuliah: " + mk.namaMK)
                    Text(text = "Kelas: " + mk.kelas)
                }


                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(onClick = { onBackButtonClicked() }) {
                        Text(text = "Home")
                    }
                }
            }


            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}