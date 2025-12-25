package com.example.profileapp.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextDecoration

@Composable
fun WebsiteLink(url: String) {
    val context = LocalContext.current

    Text(
        text = url,
        color = Color(0xFF4A5BD4),
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable {
            context.startActivity(
                Intent(Intent.ACTION_VIEW, Uri.parse(url))
            )
        }
    )
}
