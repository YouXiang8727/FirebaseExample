package com.youxiang8727.firebaseexample

import androidx.lifecycle.ViewModel
import com.youxiang8727.firebaseexample.domain.usecase.GetFirebaseUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getFirebaseUserUseCase: GetFirebaseUserUseCase
): ViewModel() {
    fun getFirebaseUser() = getFirebaseUserUseCase()
}