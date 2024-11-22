package com.example.week8_navigationmultipledata.ui.view.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class RencanaStudiViewModel : ViewModel() {
    private val _krsState = MutableStateFlow(RencanaStudi())
    val krsSta
}