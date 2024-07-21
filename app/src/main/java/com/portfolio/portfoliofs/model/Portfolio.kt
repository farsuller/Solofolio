package com.portfolio.portfoliofs.model

import com.portfolio.portfoliofs.utils.Constants.MCDELIVERY_LINK
import com.portfolio.portfoliofs.utils.Constants.PUREGOLD
import com.portfolio.portfoliofs.utils.Constants.SOLODAILY
import com.portfolio.portfoliofs.utils.Constants.SOLOEATS
import com.portfolio.portfoliofs.utils.Constants.SOLOSCAPE
import com.portfolio.portfoliofs.utils.Constants.SPARK_CLEANER_LINK
import com.portfolio.portfoliofs.utils.Constants.UNIONBANK
import com.portfolio.portfoliofs.utils.Res

enum class Portfolio(
    val image: String,
    val title: String,
    val description: String,
    val link: String,
) {
    SoloScape(
        image = Res.Image.PORTFOLIO_1,
        title = "SoloScape",
        description = "SoloScape - Version 1.0 \n" +
            "Introducing the first version of my Jetpack Compose app, now live on the Play Store—a straightforward journal app.",
        link = SOLOSCAPE,

    ),
    SoloEats(
        image = Res.Image.SOLOEATS,
        title = "SoloEats",
        description = "Note: This version is for demo purposes only and does not process real transactions.\n" +
            "We're thrilled to introduce SoloEats, your ultimate food ordering companion designed to elevate your dining experiences.",
        link = SOLOEATS,

    ),
    SoloDaily(
        image = Res.Image.SOLODAILY,
        title = "SoloDaily",
        description = "SoloDaily - Version 1.0 \n" +
            "Browse Latest News: Stay up-to-date with breaking news and trending stories from around the world. Search Functionality: Easily find articles on topics that interest you with our intuitive search feature. Bookmark Articles: Save articles for later reading with our convenient bookmarking feature.",
        link = SOLODAILY,
    ),
    McDeliveryPH(
        image = Res.Image.PORTFOLIO_3,
        title = "McDelivery PH",
        description = "During my tenure at the previous company, our team revamped and released the McDelivery PH app to the market.",
        link = MCDELIVERY_LINK,
    ),
    PuregoldMobile(
        image = Res.Image.PORTFOLIO_4,
        title = "Puregold Mobile",
        description = "I oversaw and upheld the management of this application while fulfilling my responsibilities in the DevOps position.",
        link = PUREGOLD,
    ),
    UnionBankApp(
        image = Res.Image.PORTFOLIO_5,
        title = "UnionBank Online",
        description = "I was part of a specific team that developed a feature related to installments, deployed it on the app for users, and subsequently maintained other features within different teams.",
        link = UNIONBANK,
    ),
    SparkCleaner(
        image = Res.Image.PORTFOLIO_2,
        title = "Spark Cleaner",
        description = "No longer published. Developed using android native in Kotlin.",
        link = SPARK_CLEANER_LINK,
    ),

    BetterCleaner(
        image = Res.Image.PORTFOLIO_6,
        title = "BetterCleaner",
        description = "No longer published, worked on this during my time at the previous company. Developed using android native in Java.",
        link = "",
    ),

    BetterCleanerLite(
        image = Res.Image.PORTFOLIO_7,
        title = "BetterCleaner Lite",
        description = "No longer published, worked on this during my time at the previous company. Developed using android native in Kotlin.",
        link = "",
    ),
    HuddleLive(
        image = Res.Image.PORTFOLIO_8,
        title = "huddle.live",
        description = "No longer publicly accessible, worked on this during my tenure at the previous company. Developed using android native in Kotlin.",
        link = "",
    ),
    OceanSweep(
        image = Res.Image.PORTFOLIO_9,
        title = "Ocean Sweep",
        description = "No more available publicly, worked on this during my tenure at the previous company. Our team delved into game re-skinning and enhanced features across various platforms.",
        link = "",
    ),
    PetCare(
        image = Res.Image.PORTFOLIO_10,
        title = "Pet Care",
        description = "No more available publicly, worked on this during my tenure at the previous company. Our team delved into game re-skinning and enhanced features across various platforms.",
        link = "",
    ),
    PetPony(
        image = Res.Image.PORTFOLIO_11,
        title = "Pet Pony",
        description = "No more available publicly, worked on this during my tenure at the previous company. Our team delved into game re-skinning and enhanced features across various platforms.",
        link = "",
    ),
    FunPopping(
        image = Res.Image.PORTFOLIO_12,
        title = "Fun Popping Bubbles",
        description = "No more available publicly, worked on this during my tenure at the previous company. Our team delved into game re-skinning and enhanced features across various platforms.",
        link = "",
    ),
    PrincessMagic(
        image = Res.Image.PORTFOLIO_13,
        title = "Princess Magic Beauty Potion",
        description = "No more available publicly, worked on this during my tenure at the previous company. Our team delved into game re-skinning and enhanced features across various platforms.",
        link = "",
    ),
    EarDoctor(
        image = Res.Image.PORTFOLIO_14,
        title = "Ear Doctor",
        description = "No more available publicly, worked on this during my tenure at the previous company. Our team delved into game re-skinning and enhanced features across various platforms.",
        link = "",
    ),
}
