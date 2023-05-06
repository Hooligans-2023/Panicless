package com.example.graduation.data.di

import com.example.graduation.data.apiservice.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module(includes = [NetworkModule::class])
@InstallIn(SingletonComponent::class)
class ApiModule {

    @Provides
    fun bindApiService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)
    }


}