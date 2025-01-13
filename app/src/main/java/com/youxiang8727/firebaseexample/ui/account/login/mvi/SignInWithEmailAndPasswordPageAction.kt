package com.youxiang8727.firebaseexample.ui.account.login.mvi

import com.google.firebase.auth.FirebaseUser
import com.youxiang8727.firebaseexample.Action

sealed interface SignInWithEmailAndPasswordPageAction: Action {
    data class InputEmailAddress(val emailAddress: String) : SignInWithEmailAndPasswordPageAction

    data class InputPassword(val password: String) : SignInWithEmailAndPasswordPageAction

    data object Loading : SignInWithEmailAndPasswordPageAction

    data class Success(val user: FirebaseUser) : SignInWithEmailAndPasswordPageAction

    data class Error(val error: Throwable) : SignInWithEmailAndPasswordPageAction
}