package com.youxiang8727.firebaseexample.ui.account.login.mvi

import com.google.firebase.auth.FirebaseUser
import com.youxiang8727.firebaseexample.State
import com.youxiang8727.firebaseexample.data.network.NetworkResult

data class SignInWithEmailAndPasswordPageState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false,
    val user: FirebaseUser? = null,
    val throwable: Throwable? = null
): State {
    val isLoginButtonEnabled = isEmailAddressValid() && isPasswordValid()

    private fun isEmailAddressValid(): Boolean = email.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun isPasswordValid(): Boolean = password.length in 8..30
}
