import androidx.compose.runtime.Composable
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
    MyPortfolioJCTheme(dynamicColor = false){
        MyIntroSection()
    }
}


@SolofolioPreviews
@Composable
private fun SkillsSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,){
        SkillsSection()
    }
}



@SolofolioPreviews
@Composable
private fun ServiceSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,){
        ServiceSection()
    }
}

@SolofolioPreviews
@Composable
fun ContactMeSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,){
        ContactMeSection()
    }
}


@SolofolioPreviews
@Composable
private fun FooterSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,){
        FooterSection(darkTheme = true, appVersion = "1.0.0")
    }
}