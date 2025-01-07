# Solofolio v2.2.5
Solofolio is a comprehensive app where I share all aspects of my Android development journey. 
Here, you can find detailed information about my skills, portfolio, the services I offer, 
and testimonials from clients and peers. The app is crafted using Jetpack Compose,
highlighting the latest in modern Android UI development.

## Features
- **Revamped UI**: Enjoy a fresh, modern interface designed with Jetpack Compose.
- **Profile Overview**: Get to know more about my background and experience.
- **Skills**: A detailed list of my technical skills and expertise in Android development.
- **Work Experience**: Explore a comprehensive list of my work experience, including roles, responsibilities, and achievements.
- **Portfolio**: Browse through my projects and accomplishments.
- **Services**: Information about the services I offer, including app development, consulting, and more.
- **Testimonials**: Read feedback and testimonials from my clients and colleagues.

## **How to Download**
Get started with **Solofolio** today!  
👉 [Download Now from Google Play Store](https://play.google.com/store/apps/details?id=com.portfolio.portfoliofs)

[//]: # (for windows command)
[//]: # (certutil -encode ${keystore path} ${file name key}.txt)

# ScreenshotTest

1. **Run Linting First:**
   Execute the following command to lint and organize unused imports and spacing
   ```bash
   ./gradlew spotlessApply
   
2. **Run Update Screenshot First:**
   All future test base on this generated test
   ```bash
   ./gradlew updateDebugScreenshotTest  

3. **Run Validate Screenshot** 
   Validate upcoming test
   ```bash
   ./gradlew validateDebugScreenshotTest
