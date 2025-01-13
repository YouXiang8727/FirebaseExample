package com.youxiang8727.firebaseexample.domain.usecase

import com.google.firebase.auth.FirebaseUser
import com.youxiang8727.firebaseexample.data.network.NetworkResult
import com.youxiang8727.firebaseexample.domain.repository.FireBaseAuthRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

data class CreateUserWithEmailAndPasswordUseCase @Inject constructor(
    private val fireBaseAuthRepository: FireBaseAuthRepository
) {
    operator fun invoke(
        email: String,
        password: String
    ) = flow<NetworkResult<FirebaseUser>> {
        emit(NetworkResult.Loading)

        val task = fireBaseAuthRepository.createUserWithEmailAndPassword(
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
                throw Exception("create user with email \"$email\" error, task: $task")
            }
        } else {
            throw task.exception ?: Exception("Unknown exception, task.result -> ${task.result}")
        }
    }.catch { e ->
        emit(
            NetworkResult.Error(e)
        )
    }
}