package com.portfolio.portfoliofs.presentations.sections

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.portfolio.portfoliofs.components.SectionTitle
import com.portfolio.portfoliofs.model.Section
import com.portfolio.portfoliofs.ui.theme.MyPortfolioJCTheme
import com.portfolio.portfoliofs.ui.theme.SolofolioPreviews

@Composable
fun ContactMeSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .padding(top = 15.dp)
            .testTag("contactMeSection"),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
    ) {
        SectionTitle(
            modifier = Modifier.fillMaxWidth(),
            section = Section.Contact,
            alignment = Alignment.CenterHorizontally,
        )

        EmailCard()
    }
}

@Composable
fun EmailCard() {
    var toEmail by remember { mutableStateOf("florence.suller@gmail.com") }
    var subject by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    val scrollState = rememberScrollState()
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current

    LaunchedEffect(key1 = scrollState.maxValue) {
        scrollState.scrollTo(scrollState.maxValue)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .testTag("emailCard"),
    ) {
        OutlinedTextField(
            value = toEmail,
            onValueChange = { toEmail = it },
            label = { Text("To:") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next,
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                },
            ),
        )

        OutlinedTextField(
            value = subject,
            onValueChange = { subject = it },
            label = { Text("Subject:") },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                },
            ),
        )

        OutlinedTextField(
            value = message,
            onValueChange = { message = it },
            label = { Text("Message:") },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp) // Specify the desired height
                .padding(vertical = 8.dp),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
            ),
            maxLines = 10,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center,
        ) {
            ElevatedButton(
                onClick = {
                    sendEmail(toEmail, subject, message, context)
                },
                modifier = Modifier
                    .height(50.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = "Send",
                    tint = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    text = "Submit",
                    fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
        }
    }
}

private fun sendEmail(
    toEmail: String,
    subject: String,
    message: String,
    context: android.content.Context,
) {
    val intent = Intent(Intent.ACTION_SENDTO).apply {
        data = Uri.parse("mailto:$toEmail")
        putExtra(Intent.EXTRA_SUBJECT, subject)
        putExtra(Intent.EXTRA_TEXT, message)
    }

    if (intent.resolveActivity(context.packageManager) != null) {
        context.startActivity(intent)
    } else {
        // Handle the case where the user doesn't have an email app installed.
        // You can display a message or prompt the user to install an email app.
        // For simplicity, we'll just log a message.
        println("No email app installed on the device.")
    }
}

@SolofolioPreviews
@Composable
fun ContactMeSectionPreview() {
    MyPortfolioJCTheme(
        dynamicColor = false,
    ) {
        ContactMeSection()
    }
}
