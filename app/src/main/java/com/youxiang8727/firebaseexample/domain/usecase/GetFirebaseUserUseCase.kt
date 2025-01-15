package com.youxiang8727.firebaseexample.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.youxiang8727.firebaseexample.domain.repository.FireBaseAuthRepository
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

data class GetFirebaseUserUseCase @Inject constructor(
    private val fireBaseAuthRepository: FireBaseAuthRepository
) {
    operator fun invoke(): StateFlow<FirebaseUser?> = fireBaseAuthRepository.firebaseUser
}
