package com.example.week8_navigationmultipledata.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week8_navigationmultipledata.ui.view.screen.MahasiswaFormView
import com.example.week8_navigationmultipledata.ui.view.screen.SplashView
import com.example.week8_navigationmultipledata.ui.view.viewmodel.MahasiswaViewModel


enum class Halaman{
    Splash,
    Mahasiswa,
    Data,
    Tampil
}
@Composable
fun MahasiswaApp(
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUIState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = Modifier.padding()
        ) {

        composable(route = Halaman.Splash.name){
            SplashView(onMulaiButtonClicked = {
                navController.navigate(
                    Halaman.Mahasiswa.name)
            })
        }

        composable(route = Halaman.Mahasiswa.name){
            MahasiswaFormView(onSubmitButtonClicked ={
                mahasiswaViewModel.saveDataMahasiswa(it)
                navController.navigate(Halaman.Splash.name)},
                onBackButtonCLicked = {
                    navController.popBackStack()

            })
        }

        composable(route = Halaman.)
    }
}