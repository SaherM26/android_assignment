package com.example.profileapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.profileapp.ui.components.*
import com.example.profileapp.ui.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = viewModel()
) {
    val user by viewModel.user.collectAsState()
    val loading by viewModel.loading.collectAsState()

    when {
        loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        user != null -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                ProfileHeader(
                    name = user!!.name,
                    username = user!!.username,
                    avatar = user!!.avatar,
                    location = user!!.location
                )

                Spacer(modifier = Modifier.height(16.dp))

                StatsRow(
                    followers = user!!.followers,
                    following = user!!.following
                )

//                WebsiteLink(user!!.website!!)
                SocialLinksRow(
                    website = user!!.website,
                    instagram = user!!.instagram,
                    facebook = user!!.facebook
                )

            }
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("Failed to load profile")
            }
        }
    }
}
