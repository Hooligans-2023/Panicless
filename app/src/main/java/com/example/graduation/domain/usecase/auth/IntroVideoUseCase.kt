package com.example.graduation.domain.usecase.auth

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.response.auth.IntroVideoResponse
import com.example.graduation.domain.repository.AuthRepository
import com.example.graduation.util.Resource
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class IntroVideoUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    private val TAG = "IntroVideoUseCase"
    operator fun invoke(): Flow<Resource<MainResponseModel<IntroVideoResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val loginResponse = repository.getIntroVideo()
            Log.d(TAG, "invoke: IntroVideo use case ${loginResponse.isSuccessful}")
            if (loginResponse.isSuccessful && loginResponse.body() != null) {
                loginResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                Log.d(TAG, "invoke: IntroVideo use case errorBody ${loginResponse.errorBody()}")
                val errorString = loginResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8

                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: Error IntroVideo use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception IntroVideo use case ${e.localizedMessage}")
            emit(
                Resource.Error(
                    e.localizedMessage?:""
                )
            )
        }
    }
}
