package com.portfolio.portfoliofs.model

import com.portfolio.portfoliofs.R
import com.portfolio.portfoliofs.utils.Constants.ANDROID_SERVICE
import com.portfolio.portfoliofs.utils.Constants.CROSS_PLATFORM_SERVICE
import com.portfolio.portfoliofs.utils.Constants.EDITING_SERVICE
import com.portfolio.portfoliofs.utils.Constants.IOS_SERVICE
import com.portfolio.portfoliofs.utils.Constants.UI_UX_SERVICE
import com.portfolio.portfoliofs.utils.Constants.WEB_SERVICE

enum class Service(
    val icon: Int,
    val imageDesc: String,
    val title: String,
    val description: String,
) {
    Android(
        icon = R.drawable.android_icon,
        imageDesc = "Android Icon",
        title = "Android Development",
        description = ANDROID_SERVICE,
    ),
    IOS(
        icon = R.drawable.apple_icon,
        imageDesc = "Apple Icon",
        title = "iOS Development",
        description = IOS_SERVICE,
    ),
    Web(
        icon = R.drawable.web_icon,
        imageDesc = "Desktop Icon",
        title = "Web Development",
        description = WEB_SERVICE,
    ),
    CrossPlatform(
        icon = R.drawable.cross_platform_icon,
        imageDesc = "Cross Platform Icon",
        title = "Cross Platform Development",
        description = CROSS_PLATFORM_SERVICE,
    ),
    Design(
        icon = R.drawable.design_icon,
        imageDesc = "Pen Icon",
        title = "UI/UX Design",
        description = UI_UX_SERVICE,
    ),
    Video(
        icon = R.drawable.video_icon,
        imageDesc = "Video Icon",
        title = "Video Editing",
        description = EDITING_SERVICE,
        ),
}
