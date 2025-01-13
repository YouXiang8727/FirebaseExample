package com.youxiang8727.firebaseexample.ui.account.login.mvi

import com.youxiang8727.firebaseexample.Reducer
import com.youxiang8727.firebaseexample.data.network.NetworkResult

class SignInWithEmailAndPasswordPageReducer: Reducer<SignInWithEmailAndPasswordPageState, SignInWithEmailAndPasswordPageAction> {
    override fun reduce(state: SignInWithEmailAndPasswordPageState, action: SignInWithEmailAndPasswordPageAction): SignInWithEmailAndPasswordPageState {
        return when (action) {
            is SignInWithEmailAndPasswordPageAction.InputEmailAddress -> {
                state.copy(
                    email = action.emailAddress,
                    isLoading = false,
                    user = null,
                    throwable = null
                )
            }

            is SignInWithEmailAndPasswordPageAction.InputPassword -> {
                state.copy(
                    password = action.password,
                    isLoading = false,
                    user = null,
                    throwable = null
                )
            }

            is SignInWithEmailAndPasswordPageAction.Loading -> {
                state.copy(
                    isLoading = true
                )
            }

            is SignInWithEmailAndPasswordPageAction.Error -> {
                state.copy(
                    isLoading = false,
                    throwable = action.error
                )
            }

            is SignInWithEmailAndPasswordPageAction.Success -> {
                state.copy(
                    isLoading = false,
                    user = action.user
                )
            }
        }
    }
}