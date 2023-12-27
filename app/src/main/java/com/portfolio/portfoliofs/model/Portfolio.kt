package com.portfolio.portfoliofs.model


import com.portfolio.portfoliofs.utils.Constants.MCDELIVERY_LINK
import com.portfolio.portfoliofs.utils.Constants.PUREGOLD
import com.portfolio.portfoliofs.utils.Constants.SOLOSCAPE
import com.portfolio.portfoliofs.utils.Constants.SPARK_CLEANER_LINK
import com.portfolio.portfoliofs.utils.Constants.UNIONBANK
import com.portfolio.portfoliofs.utils.Res


enum class Portfolio(
    val image:String,
    val title:String,
    val description:String,
    val link:String,
) {
    One(
        image = Res.Image.portfolio1,
        title = "SoloScape",
        description = "SoloScape - Version 1.0 \n" +
                "Introducing the first version of my Jetpack Compose app, now live on the Play Store—a straightforward journal app.",
        link = SOLOSCAPE

    ),
    Two(
        image = Res.Image.portfolio2,
        title = "Spark Cleaner",
        description = "My personal app is currently unpublished, as I have ceased maintaining and updating it, including any requirements on the Play Store.",
        link = SPARK_CLEANER_LINK
    ),
    Three(
        image = Res.Image.portfolio3,
        title = "McDelivery PH",
        description = "Our team redesigned and launched the McDelivery PH app on the market while I was still employed at my previous company.",
        link = MCDELIVERY_LINK
    ),
    Four(
        image = Res.Image.portfolio4,
        title = "Puregold Mobile",
        description = "I managed and maintained this app during my time in the DevOps role",
        link = PUREGOLD
    ),
    Five(
        image = Res.Image.portfolio5,
        title = "UnionBank Online",
        description = "I was part of a specific team that developed a feature related to installments, deployed it on the app for users, and subsequently maintained other features within different teams.",
        link = UNIONBANK
    ),

}