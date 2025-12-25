package com.example.profileapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.profileapp.data.model.User
import com.example.profileapp.data.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    private val repository = UserRepository()

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user

    private val _loading = MutableStateFlow(true)
    val loading: StateFlow<Boolean> = _loading

    init {
        loadProfile()
    }

    private fun loadProfile() {
        viewModelScope.launch {
            _loading.value = true
            val result = repository.fetchUser()
            _user.value = result.getOrNull()
            _loading.value = false
        }
    }
}
