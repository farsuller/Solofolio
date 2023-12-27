package com.portfolio.portfoliofs.model

import com.portfolio.portfoliofs.utils.Res


enum class Achievements (
    val icon:String,
    val number: Int,
    val description: String){

    Completed(
        icon = Res.Icon.checkmark,
        number = 120,
        description = "Completed Projects"
    ),
    Active(
        icon = Res.Icon.shield,
        number = 12,
        description = "Active Projects"
    ),
    Satisfied(
        icon = Res.Icon.happy,
        number = 42,
        description = "Satisfied Clients"
    ),
    Team(
        icon = Res.Icon.team,
        number = 10,
        description = "Team Members"
    ),
}