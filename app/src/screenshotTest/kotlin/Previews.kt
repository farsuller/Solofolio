import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.portfolio.portfoliofs.components.PortfolioCard
import com.portfolio.portfoliofs.components.ServiceCard
import com.portfolio.portfoliofs.components.SkillCardV2
import com.portfolio.portfoliofs.components.SocialBar
import com.portfolio.portfoliofs.components.TestimonialCard
import com.portfolio.portfoliofs.model.Portfolio
import com.portfolio.portfoliofs.model.Service
import com.portfolio.portfoliofs.model.Skills
import com.portfolio.portfoliofs.model.Testimonial
import com.portfolio.portfoliofs.presentations.sections.ContactMeSection
import com.portfolio.portfoliofs.presentations.sections.FooterSection
import com.portfolio.portfoliofs.presentations.sections.MyIntroSection
import com.portfolio.portfoliofs.presentations.sections.ServiceSection
import com.portfolio.portfoliofs.presentations.sections.SkillsSection
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@SolofolioPreviews
@Composable
private fun MyIntroSectionPreview() {
    MyPortfolioJCTheme(dynamicColor = false) {
        Surface { MyIntroSection() }
    }
}

@SolofolioPreviews
@Composable
private fun SkillsSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface { SkillsSection() }
    }
}

@SolofolioPreviews
@Composable
private fun ServiceSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface { ServiceSection() }
    }
}

@SolofolioPreviews
@Composable
fun ContactMeSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface { ContactMeSection() }
    }
}

@SolofolioPreviews
@Composable
private fun FooterSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface { FooterSection(darkTheme = true, appVersion = "1.0.0") }
    }
}

@SolofolioPreviews
@Composable
private fun SocialBarPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface { SocialBar() }
    }
}

@SolofolioPreviews
@Composable
fun SkillCardV2Preview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            SkillCardV2(Skills.entries.toTypedArray())
        }
    }
}

@SolofolioPreviews
@Composable
fun TestimonialCardPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            TestimonialCard(Testimonial.entries.toTypedArray()[0])
        }
    }
}

@SolofolioPreviews
@Composable
fun ServiceCardPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            ServiceCard(Service.entries.toTypedArray()[0])
        }
    }
}

@SolofolioPreviews
@Composable
private fun PortfolioCardPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        Surface {
            PortfolioCard(Portfolio.entries.toTypedArray()[0])
        }
    }
}
