package com.portfolio.portfoliofs.model

import com.portfolio.portfoliofs.utils.Constants.COLLABERA
import com.portfolio.portfoliofs.utils.Constants.EMAPTA
import com.portfolio.portfoliofs.utils.Constants.YONDU
import com.portfolio.portfoliofs.utils.Constants.ZIGZAG
import com.portfolio.portfoliofs.utils.Res


enum class Experience(
    val number:String,
    val jobPosition:String,
    val description:String,
    val company:String,
    val image: String,
    val from:String,
    val to:String
) {
    First(
        number = "01",
        jobPosition = "Jr. Mobile Application Developer",
        description = ZIGZAG,
        company = "Zigzag OffShoring",
        image = Res.Image.work1,
        from = "March 2017",
        to = "December 2020"
    ),
    Second(
        number = "02",
        jobPosition = "Jr. Mobile Application Developer",
        description = EMAPTA,
        company = "EMAPTA",
        image = Res.Image.work2,
        from = "January 2020",
        to = "September 2020"
    ),
    Third(
        number = "03",
        jobPosition = "(Software Engineer) Android Mobile Developer",
        description = YONDU,
        company = "Yondu Inc.",
        image = Res.Image.work3,
        from = "September 2020",
        to = "February 2022"
    ),
    Fourth(
        number = "04",
        jobPosition = "Android Developer",
        description = COLLABERA,
        company = "Collabera Digital",
        image = Res.Image.work4,
        from = "February 2022",
        to = "Present"
    ),
}