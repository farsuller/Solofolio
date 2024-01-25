package com.portfolio.portfoliofs.presentations

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var emailState by mutableStateOf(EmailState())
    data class EmailState(
        var toEmail: String = "",
        var subject: String = "",
        var message: String = "",
    )
}
