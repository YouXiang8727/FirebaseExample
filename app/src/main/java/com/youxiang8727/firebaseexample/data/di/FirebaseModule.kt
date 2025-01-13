package com.youxiang8727.firebaseexample.data.di

import com.youxiang8727.firebaseexample.domain.repository.FireBaseAuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FirebaseModule {

    @Provides
    @Singleton
    fun provideFirebaseAuthRepository(): FireBaseAuthRepository = com.youxiang8727.firebaseexample.data.repository.FireBaseAuthRepository()
}