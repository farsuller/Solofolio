package com.portfolio.portfoliofs.presentations

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.soloscape.util.connectivity.ConnectivityObserver
import com.soloscape.util.connectivity.NetworkConnectivityObserver


class MainViewModel : ViewModel() {

    var emailState by mutableStateOf(EmailState())


    data class EmailState(
        var toEmail: String = "",
        var subject: String = "",
        var message: String = ""
    )
}