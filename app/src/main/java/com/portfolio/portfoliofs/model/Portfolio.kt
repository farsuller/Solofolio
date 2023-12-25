package com.portfolio.portfoliofs.model


import com.far.suller.util.Constants.MCDELIVERY_LINK
import com.far.suller.util.Constants.PORFOLIOF
import com.far.suller.util.Constants.PUREGOLD
import com.far.suller.util.Constants.SPARK_CLEANER_LINK
import com.far.suller.util.Constants.UNIONBANK
import com.far.suller.util.Res


enum class Portfolio(
    val image:String,
    val title:String,
    val description:String,
    val link:String,
) {
    One(
        image = Res.Image.portfolio1,
        title = "Porfoliofs",
        description = "Feel free to install if you're interested in exploring a simple Flutter portfolio app. It's my first Flutter app that has been published on the Play Store.",
        link = PORFOLIOF

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