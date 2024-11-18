package com.portfolio.portfoliofs

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.portfolio.portfoliofs.components.PortfolioCard
import com.portfolio.portfoliofs.components.ServiceCard
import com.portfolio.portfoliofs.components.SkillCardV2
import com.portfolio.portfoliofs.components.TestimonialCard
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.model.Service
import com.portfolio.portfoliofs.model.Skills
import com.portfolio.portfoliofs.model.Testimonial
import com.portfolio.portfoliofs.presentations.sections.ContactMeSection
import com.portfolio.portfoliofs.presentations.sections.EmailCard
import com.portfolio.portfoliofs.presentations.sections.FooterSection
import com.portfolio.portfoliofs.presentations.sections.MyIntroSection
import com.portfolio.portfoliofs.presentations.sections.PortfolioSection
import com.portfolio.portfoliofs.presentations.sections.ServiceSection
import com.portfolio.portfoliofs.presentations.sections.SkillsSection
import com.portfolio.portfoliofs.presentations.sections.TestimonialSection
import org.junit.Rule
import org.junit.Test

class SolofolioScreenTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    private val skills = Skills.entries.toTypedArray()
    private val portfolio = Portfolio.entries.toTypedArray()
    private val services = Service.entries.toTypedArray()
    private val testimonial = Testimonial.entries.toTypedArray()

    @Test
    fun introSectionTest() {
        composeTestRule.setContent {
            MyIntroSection()
        }
        composeTestRule.onNodeWithTag("introSection").assertExists()

        composeTestRule.onNodeWithTag("introText").assertExists()
    }

    @Test
    fun skillSectionTest() {
        composeTestRule.setContent {
            SkillsSection()
        }
        composeTestRule.onNodeWithTag("skillsSection").assertExists()
    }

    @Test
    fun skillCardTest() {
        composeTestRule.setContent {
            SkillCardV2(skills)
        }
        composeTestRule.onNodeWithTag("skillsFlowRow").assertExists()
    }

    @Test
    fun portfolioSectionTest() {
        composeTestRule.setContent {
            PortfolioSection()
        }
        composeTestRule.onNodeWithTag("portfolioSection").assertExists()
    }

    @Test
    fun portfolioCardTest() {
        composeTestRule.setContent {
            PortfolioCard(portfolio[1])
        }
        composeTestRule.onNodeWithTag("portfolioCard").assertExists()
    }

    @Test
    fun serviceSectionTest() {
        composeTestRule.setContent {
            ServiceSection()
        }
        composeTestRule.onNodeWithTag("serviceSection").assertExists()
    }

    @Test
    fun serviceCardTest() {
        composeTestRule.setContent {
            ServiceCard(services[1])
        }
        composeTestRule.onNodeWithTag("serviceCard").assertExists()
    }

    @Test
    fun testimonialSectionTest() {
        composeTestRule.setContent {
            TestimonialSection()
        }
        composeTestRule.onNodeWithTag("testimonialSection").assertExists()
    }

    @Test
    fun testimonialCardTest() {
        composeTestRule.setContent {
            TestimonialCard(testimonial[0])
        }
        composeTestRule.onNodeWithTag("testimonialCard").assertExists()
    }

    @Test
    fun contactMeSectionTest() {
        composeTestRule.setContent {
            ContactMeSection()
        }
        composeTestRule.onNodeWithTag("contactMeSection").assertExists()
    }

    @Test
    fun emailCardTest() {
        composeTestRule.setContent {
            EmailCard()
        }
        composeTestRule.onNodeWithTag("emailCard").assertExists()
    }

    @Test
    fun footerSectionTest() {
        composeTestRule.setContent {
            FooterSection(false, "1.0.0")
        }
        composeTestRule.onNodeWithTag("footerSection").assertExists()
    }
}
