package com.youxiang8727.firebaseexample.data.repository

import com.google.android.gms.tasks.Task
import com.google.firebase.Firebase
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.auth
import com.youxiang8727.firebaseexample.domain.repository.FireBaseAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FireBaseAuthRepository @Inject constructor(): FireBaseAuthRepository {
    override val auth = Firebase.auth

    override fun signInWithEmailAndPassword(
        email: String,
        password: String
    ) : Task<AuthResult> {
        return auth.signInWithEmailAndPassword(
            email,
            password
        )
    }

    override fun createUserWithEmailAndPassword(
        email: String,
        password: String
    ) : Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(
            email,
            password
        )
    }

    override suspend fun signOut() {
        auth.signOut()
    }

    init {
        println("FirebaseAuthRepository($this) initialized")
    }
}