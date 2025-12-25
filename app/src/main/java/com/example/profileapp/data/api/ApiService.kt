package com.example.profileapp.data.api

import com.example.profileapp.data.model.User
import retrofit2.http.GET

interface ApiService {
    @GET("profile.json")
    suspend fun getUser(): User
}
