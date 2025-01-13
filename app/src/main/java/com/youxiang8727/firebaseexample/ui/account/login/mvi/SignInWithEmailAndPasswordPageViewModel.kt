package com.youxiang8727.firebaseexample.ui.account.login.mvi

import androidx.lifecycle.viewModelScope
import com.youxiang8727.firebaseexample.MviViewModel
import com.youxiang8727.firebaseexample.data.network.NetworkResult
import com.youxiang8727.firebaseexample.domain.usecase.CreateUserWithEmailAndPasswordUseCase
import com.youxiang8727.firebaseexample.domain.usecase.SignInWithEmailAndPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInWithEmailAndPasswordPageViewModel @Inject constructor(
    private val signInWithEmailAndPasswordUseCase: SignInWithEmailAndPasswordUseCase,
    private val createUserWithEmailAndPasswordUseCase: CreateUserWithEmailAndPasswordUseCase
): MviViewModel<SignInWithEmailAndPasswordPageState, SignInWithEmailAndPasswordPageAction>(
    initialState = SignInWithEmailAndPasswordPageState(),
    reducer = SignInWithEmailAndPasswordPageReducer()
) {
    fun inputEmailAddress(email: String) {
        dispatch(
            SignInWithEmailAndPasswordPageAction.InputEmailAddress(email)
        )
    }

    fun inputPassword(password: String) {
        dispatch(
            SignInWithEmailAndPasswordPageAction.InputPassword(password)
        )
    }

    fun signInWithEmailAndPassword() {
        viewModelScope.launch {
            signInWithEmailAndPasswordUseCase(
                state.email,
                state.password
            ).collect { result ->
                println("signInWithEmailAndPasswordUseCase.collect -> $result")
                when (result) {
                    is NetworkResult.Loading -> {
                        dispatch(
                            SignInWithEmailAndPasswordPageAction.Loading
                        )
                    }

                    is NetworkResult.Error -> {
                        dispatch(
                            SignInWithEmailAndPasswordPageAction.Error(
                                result.throwable
                            )
                        )
                    }

                    is NetworkResult.Success -> {
                        dispatch(
                            SignInWithEmailAndPasswordPageAction.Success(
                                result.result
                            )
                        )
                    }
                }
            }
        }
    }

    fun createUserWithEmailAndPassword() {
        viewModelScope.launch {
            createUserWithEmailAndPasswordUseCase(
                state.email,
                state.password
            ).collect { result ->
                println("createUserWithEmailAndPasswordUseCase.collect -> $result")
                when (result) {
                    is NetworkResult.Loading -> {
                        dispatch(
                            SignInWithEmailAndPasswordPageAction.Loading
                        )
                    }

                    is NetworkResult.Error -> {
                        dispatch(
                            SignInWithEmailAndPasswordPageAction.Error(
                                result.throwable
                            )
                        )
                    }

                    is NetworkResult.Success -> {
                        dispatch(
                            SignInWithEmailAndPasswordPageAction.Success(
                                result.result
                            )
                        )
                    }
                }
            }
        }
    }
}