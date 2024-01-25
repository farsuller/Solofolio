package com.portfolio.portfoliofs.model

import com.portfolio.portfoliofs.utils.Res

enum class Testimonial(
    val image: String,
    val fullName: String,
    val profession: String,
    val review: String,
) {
    First(
        image = Res.Image.avatar1,
        fullName = "Reynaleen Soriano",
        profession = "CEO - Technation",
        review = "His coding prowess and attention to detail ensured our mobile app exceeded expectations.",
    ),

    Second(
        image = Res.Image.avatar2,
        fullName = "Raymart Entuna",
        profession = "Sr. Dotnet  Developer",
        review = "Brought a new level of expertise to our team. His dedication to creating seamless user experiences is unmatched.",
    ),

    Third(
        image = Res.Image.avatar3,
        fullName = "Marinella Esperancilla",
        profession = "SAP Consultant",
        review = "His ability to solve complex problems and deliver elegant solutions is commendable.",
    ),

    Fourth(
        image = Res.Image.avatar4,
        fullName = "Daniel Olleres",
        profession = "Multimedia Supervisor",
        review = "He demonstrated remarkable proficiency in crafting visual appealing mobile applications.",
    ),

    Fifth(
        image = Res.Image.avatar5,
        fullName = "Ellen Grace Fabregas",
        profession = "Business Analyst",
        review = "His collaboration and technical skills greatly contributed to our success.",
    ),

    Sixth(
        image = Res.Image.avatar6,
        fullName = "Jennilyn Pagaran Aclag",
        profession = "Technical Standard Engineer",
        review = "He ensured that projects adhered in to great technical standards. His commitment to excellence is truly commendable.",
        ),
}
