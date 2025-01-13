package com.youxiang8727.firebaseexample.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.youxiang8727.firebaseexample.data.network.NetworkResult
import com.youxiang8727.firebaseexample.domain.repository.FireBaseAuthRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

data class SignInWithEmailAndPasswordUseCase @Inject constructor(
    private val fireBaseAuthRepository: FireBaseAuthRepository
) {
    operator fun invoke(
        email: String,
        password: String
    ) = flow<NetworkResult<FirebaseUser>> {
        emit(NetworkResult.Loading)

        val task = fireBaseAuthRepository.signInWithEmailAndPassword(
            email,
            password
        )

        task.await()

        if (task.isSuccessful) {
            val user = task.result.user

            if (user != null) {
                emit(
                    NetworkResult.Success(user)
                )
            } else {
                emit(
                    NetworkResult.Error(
                        Exception("User is null, task.result -> ${task.result}")
                    )
                )
            }
        }else {
            throw task.exception ?: Exception("Unknown exception, task.result -> ${task.result}")
        }
    }.catch { e ->
        emit(
            NetworkResult.Error(e)
        )
    }
}