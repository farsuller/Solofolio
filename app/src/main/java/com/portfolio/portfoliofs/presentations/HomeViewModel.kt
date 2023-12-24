package com.portfolio.portfoliofs.presentations

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.soloscape.util.connectivity.ConnectivityObserver
import com.soloscape.util.connectivity.NetworkConnectivityObserver


internal class HomeViewModel (
    private val connectivity: NetworkConnectivityObserver,
): ViewModel() {

    private var network by mutableStateOf(ConnectivityObserver.Status.Unavailable)

    init {

    }


}