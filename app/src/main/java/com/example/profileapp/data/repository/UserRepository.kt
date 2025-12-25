package com.example.profileapp.data.repository

import com.example.profileapp.data.api.RetrofitInstance
import com.example.profileapp.data.model.User

class UserRepository {

    suspend fun fetchUser(): Result<User> {
        return try {
            val user = RetrofitInstance.api.getUser()
            Result.success(user)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
