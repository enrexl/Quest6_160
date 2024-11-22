package com.example.week8_navigationmultipledata.Navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.week8_navigationmultipledata.ui.view.screen.MahasiswaFormView
import com.example.week8_navigationmultipledata.ui.view.screen.RencanaStudiView
import com.example.week8_navigationmultipledata.ui.view.screen.SplashView
import com.example.week8_navigationmultipledata.ui.view.screen.TampilDataView
import com.example.week8_navigationmultipledata.ui.view.viewmodel.MahasiswaViewModel
import com.example.week8_navigationmultipledata.ui.view.viewmodel.RencanaStudiViewModel


enum class Halaman{
    Splash,
    Mahasiswa,
    Data,
    Tampil
}
@Composable
fun MahasiswaApp(
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    rencanaStudiViewModel: RencanaStudiViewModel = viewModel(),
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {

    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUIState.collectAsState().value
    val krsUiState = rencanaStudiViewModel.krsStateui.collectAsState().value


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
                navController.navigate(Halaman.Data.name)},
                onBackButtonCLicked = {
                    navController.popBackStack()

            })
        }

        composable(route = Halaman.Data.name){
            RencanaStudiView( mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {
                rencanaStudiViewModel.saveDataKRS(it)
                navController.navigate(Halaman.Tampil.name)},
                onBackButtonClicked = {
                    navController.popBackStack()
            })
        }

        composable(route = Halaman.Tampil.name) {
            TampilDataView(
                 mk = krsUiState,
                mhs = mahasiswaUiState,
                onSubmitButtonClicked =  {},
                onBackButtonClicked = { navController.navigate(Halaman.Splash.name)}
            )

        }
    }
}