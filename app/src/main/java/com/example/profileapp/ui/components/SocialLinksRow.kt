package com.example.profileapp.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.profileapp.R

@Composable
fun SocialLinksRow(
    website: String?,
    instagram: String?,
    facebook: String?
) {

    val context = LocalContext.current

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        fun open(url: String) {
            context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
        }

        if (!website.isNullOrBlank()) {
            Image(
                painter = painterResource(R.drawable.website),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { open(website) }
            )
        }

        Spacer(Modifier.width(24.dp))

        if (!instagram.isNullOrBlank()) {
            Image(
                painter = painterResource(R.drawable.insta),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { open(instagram) }
            )
        }

        Spacer(Modifier.width(24.dp))

        if (!facebook.isNullOrBlank()) {
            Image(
                painter = painterResource(R.drawable.facebook),
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .clickable { open(facebook) }
            )
        }
    }
}
