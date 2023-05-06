package com.example.graduation.data.di.module

import com.example.graduation.data.apiservice.AuthService
import com.example.graduation.data.repository.remote.AuthRepositoryImpl
import com.example.graduation.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideAuthRepository(api: AuthService): AuthRepository {
        return AuthRepositoryImpl(api)
    }



}