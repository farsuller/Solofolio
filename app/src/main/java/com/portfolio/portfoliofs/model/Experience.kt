package com.portfolio.portfoliofs.model

import com.far.suller.util.Constants.COLLABERA
import com.far.suller.util.Constants.EMAPTA
import com.far.suller.util.Constants.YONDU
import com.far.suller.util.Constants.ZIGZAG


enum class Experience(
    val number:String,
    val jobPosition:String,
    val description:String,
    val company:String,
    val from:String,
    val to:String
) {
    First(
        number = "01",
        jobPosition = "Jr. Mobile Application Developer",
        description = ZIGZAG,
        company = "Zigzag OffShoring",
        from = "March 2017",
        to = "December 2020"
    ),
    Second(
        number = "02",
        jobPosition = "Jr. Mobile Application Developer",
        description = EMAPTA,
        company = "EMAPTA",
        from = "January 2020",
        to = "September 2020"
    ),
    Third(
        number = "03",
        jobPosition = "(Software Engineer) Android Mobile Developer",
        description = YONDU,
        company = "Yondu Inc.",
        from = "September 2020",
        to = "February 2022"
    ),
    Fourth(
        number = "04",
        jobPosition = "Android Developer",
        description = COLLABERA,
        company = "Collabera Digital",
        from = "February 2022",
        to = "Present"
    ),
}