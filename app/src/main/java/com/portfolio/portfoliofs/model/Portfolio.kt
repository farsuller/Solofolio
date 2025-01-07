package com.portfolio.portfoliofs.model

import androidx.compose.ui.graphics.Color
import com.portfolio.portfoliofs.ui.theme.AnimeLoomColor
import com.portfolio.portfoliofs.ui.theme.AnimeLoomDarkColor
import com.portfolio.portfoliofs.ui.theme.CurrenzyColor
import com.portfolio.portfoliofs.ui.theme.CurrenzyDarkColor
import com.portfolio.portfoliofs.ui.theme.McDeliveryColor
import com.portfolio.portfoliofs.ui.theme.McDeliveryDarkColor
import com.portfolio.portfoliofs.ui.theme.NeutralColor
import com.portfolio.portfoliofs.ui.theme.OtherAppsColor
import com.portfolio.portfoliofs.ui.theme.OtherAppsDarkColor
import com.portfolio.portfoliofs.ui.theme.SoloDailyColor
import com.portfolio.portfoliofs.ui.theme.SoloDailyDarkColor
import com.portfolio.portfoliofs.ui.theme.SoloEatsColor
import com.portfolio.portfoliofs.ui.theme.SoloEatsDarkColor
import com.portfolio.portfoliofs.ui.theme.SoloScapeColor
import com.portfolio.portfoliofs.ui.theme.SoloScapeDarkColor
import com.portfolio.portfoliofs.ui.theme.UnionBankColor
import com.portfolio.portfoliofs.ui.theme.UnionBankDarkColor
import com.portfolio.portfoliofs.utils.Constants.ANIMELOOM
import com.portfolio.portfoliofs.utils.Constants.CURRENZY
import com.portfolio.portfoliofs.utils.Constants.GITHUB_LINK_ANIMELOOM
import com.portfolio.portfoliofs.utils.Constants.GITHUB_LINK_CURRENZY
import com.portfolio.portfoliofs.utils.Constants.GITHUB_LINK_SOLODAILY
import com.portfolio.portfoliofs.utils.Constants.GITHUB_LINK_SOLOEATS
import com.portfolio.portfoliofs.utils.Constants.GITHUB_LINK_SOLOSCAPE
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
    val lightColor: Color = NeutralColor,
    val darkColor: Color = NeutralColor,
    val githubLink: String = "",
) {
    AnimeLoom(
        image = Res.Image.ANIMELOOM,
        title = "AnimeLoom",
        description = "A seamless experience for anime and manga lovers, offering comprehensive details, summaries, and insights on your favorite series. Explore, bookmark, and stay updated with ease",
        link = ANIMELOOM,
        lightColor = AnimeLoomColor,
        darkColor = AnimeLoomDarkColor,
        githubLink = GITHUB_LINK_ANIMELOOM,
    ),
    Currenzy(
        image = Res.Image.CURRENZY,
        title = "Currenzy",
        description = "A straightforward currency converter app that allows users to check live exchange rates ",
        link = CURRENZY,
        lightColor = CurrenzyColor,
        darkColor = CurrenzyDarkColor,
        githubLink = GITHUB_LINK_CURRENZY,
    ),
    SoloScape(
        image = Res.Image.SOLOSCAPE,
        title = "SoloScape",
        description = "A refined and intuitive experience, designed to help users focus on capturing ideas and journaling effortlessly.",
        link = SOLOSCAPE,
        lightColor = SoloScapeColor,
        darkColor = SoloScapeDarkColor,
        githubLink = GITHUB_LINK_SOLOSCAPE,
    ),
    SoloEats(
        image = Res.Image.SOLOEATS,
        title = "SoloEats",
        description = "A personal food ordering app designed to showcase modern Android development practices.",
        link = SOLOEATS,
        lightColor = SoloEatsColor,
        darkColor = SoloEatsDarkColor,
        githubLink = GITHUB_LINK_SOLOEATS,
    ),
    SoloDaily(
        image = Res.Image.SOLODAILY,
        title = "SoloDaily",
        description = "Browse Latest News: Stay up-to-date with breaking news and trending stories from around the world.",
        link = SOLODAILY,
        lightColor = SoloDailyColor,
        darkColor = SoloDailyDarkColor,
        githubLink = GITHUB_LINK_SOLODAILY,
    ),

    UnionBankApp(
        image = Res.Image.UNIONBANK,
        title = "UnionBank Online",
        description = "During my tenure at the previous company and subsequently maintained other features within different teams.",
        link = UNIONBANK,
        lightColor = UnionBankColor,
        darkColor = UnionBankDarkColor,
    ),
    McDeliveryPH(
        image = Res.Image.MCDELIVERY,
        title = "McDelivery PH",
        description = "During my tenure at the previous company, our team revamped and released the McDelivery PH app to the market.",
        link = MCDELIVERY_LINK,
        lightColor = McDeliveryColor,
        darkColor = McDeliveryDarkColor,
    ),

    OtherApps(
        image = Res.Image.OTHERAPPS,
        title = "Other Apps",
        description = "Worked on other apps during my tenure at the previous company.",
        link = "",
        lightColor = OtherAppsColor,
        darkColor = OtherAppsDarkColor,
    ),

    PuregoldMobile(
        image = Res.Image.PORTFOLIO_4,
        title = "Puregold Mobile",
        description = "I oversaw and upheld the management of this application while fulfilling my responsibilities in the DevOps position.",
        link = PUREGOLD,
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
