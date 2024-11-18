package com.portfolio.portfoliofs.model

import com.portfolio.portfoliofs.utils.Constants.BCS
import com.portfolio.portfoliofs.utils.Constants.COLLABERA
import com.portfolio.portfoliofs.utils.Constants.EMAPTA
import com.portfolio.portfoliofs.utils.Constants.FPT
import com.portfolio.portfoliofs.utils.Constants.YONDU
import com.portfolio.portfoliofs.utils.Constants.ZIGZAG
import com.portfolio.portfoliofs.utils.Res

enum class Experience(
    val id: Int,
    val jobPosition: String,
    val description: List<String>,
    val company: String,
    val image: String,
    val from: String,
    val to: String,
) {
    First(
        id = 1,
        jobPosition = "Jr. Mobile Application Developer",
        description = ZIGZAG,
        company = "Zigzag OffShoring",
        image = Res.Image.WORK_1,
        from = "Mar. 2017",
        to = "Dec. 2019",
    ),
    Second(
        id = 2,
        jobPosition = "Jr. Mobile Application Developer",
        description = EMAPTA,
        company = "EMAPTA",
        image = Res.Image.WORK_2,
        from = "Jan. 2020",
        to = "Sept. 2020",
    ),
    Third(
        id = 3,
        jobPosition = "(Software Engineer) Android Mobile Developer",
        description = YONDU,
        company = "Yondu Inc.",
        image = Res.Image.WORK_3,
        from = "Sept. 2020",
        to = "Feb. 2022",
    ),
    Fourth(
        id = 4,
        jobPosition = "Android Developer",
        description = COLLABERA,
        company = "Collabera Digital",
        image = Res.Image.WORK_4,
        from = "Feb. 2022",
        to = "Jan. 2024",
    ),
    Fifth(
        id = 5,
        jobPosition = "Software Developer Engineer",
        description = FPT,
        company = "FPT Software Philippines Corp.",
        image = Res.Image.WORK_5,
        from = "Feb. 2024",
        to = "Oct. 2024",
    ),
    Sixth(
        id = 6,
        jobPosition = "Android Developer",
        description = BCS,
        company = "BCS Technology International Pty Ltd",
        image = Res.Image.WORK_6,
        from = "Oct. 2024",
        to = "Present",
    ),
}
