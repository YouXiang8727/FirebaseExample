package com.youxiang8727.firebaseexample.domain.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.StateFlow

interface FireBaseAuthRepository {
    val auth: FirebaseAuth

    val firebaseUser: StateFlow<FirebaseUser?>

    fun signInWithEmailAndPassword(
        email: String,
        password: String
    ): Task<AuthResult>

    fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ): Task<AuthResult>

    suspend fun signOut()
}