package me.vlasoff.afa.presentation.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.FirebaseException
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import me.vlasoff.afa.data.repositories.AuthRepository
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _state = MutableLiveData<AuthState>()
    val state: LiveData<AuthState>
        get() = _state

    fun signIn(email: String, password: String) {
        viewModelScope.launch {
            try {
                authRepository.signIn(email, password).user?.let {
                    _state.postValue(AuthState.Authorized)
                } ?: run {
                    _state.postValue(AuthState.Failed)
                }
            } catch (e: FirebaseException) {
                _state.postValue(AuthState.Failed)
            }
        }
    }

    fun signUp(email: String, password: String) {
        viewModelScope.launch {
            try {
                authRepository.signUp(email, password).user?.let {
                    _state.postValue(AuthState.Authorized)
                } ?: run {
                    _state.postValue(AuthState.Failed)
                }
            } catch (e: FirebaseException) {
                _state.postValue(AuthState.Failed)
            }
        }
    }

    enum class AuthState {
        Authorized, Failed, None
    }
}