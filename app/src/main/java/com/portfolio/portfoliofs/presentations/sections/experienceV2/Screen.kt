package com.portfolio.portfoliofs.presentations.sections.experienceV2

import kotlinx.serialization.Serializable

@Serializable
data object ListScreen

@Serializable
data class DetailScreen(
    val id: Int,
    val companyName: String,
    val companyImage: String,
    val jobPosition: String,
    val description: List<String>,
    val from: String,
    val to: String,
)
