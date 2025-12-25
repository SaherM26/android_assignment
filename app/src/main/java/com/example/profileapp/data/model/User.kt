package com.example.profileapp.data.model

data class User(
    val name: String,
    val username: String,
    val avatar: String,
    val location: String,
    val followers: Int,
    val following: Int,
    val website: String?,
    val instagram: String?,
    val facebook: String?
)

