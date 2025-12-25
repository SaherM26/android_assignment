package com.example.profileapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ProfileHeader(
    name: String,
    username: String,
    avatar: String,
    location: String
) {
    CurvedHeader {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = avatar,
                contentDescription = null,
                modifier = Modifier
                    .size(96.dp)
                    .clip(CircleShape)
            )
            Spacer(Modifier.height(12.dp))
            Text(name, color = MaterialTheme.colorScheme.onPrimary)
            Text("@$username", color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f))
            Text(location, color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.7f))
        }
    }
}
