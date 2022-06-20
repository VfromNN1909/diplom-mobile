package me.vlasoff.afa.data.repositories

import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await
import me.vlasoff.afa.domain.repository.IRepository

class AuthRepository : IRepository.IAuthRepository {

    private lateinit var auth: FirebaseAuth

    override suspend fun signIn(email: String, password: String): AuthResult {
        auth = Firebase.auth
        return auth.signInWithEmailAndPassword(email, password).await()
    }

    override suspend fun signUp(email: String, password: String): AuthResult {
        auth = Firebase.auth
        return auth.createUserWithEmailAndPassword(email, password).await()
    }
}