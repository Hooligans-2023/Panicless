package com.example.graduation.domain.usecase.auth

import android.util.Log
import com.example.graduation.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.response.auth.LoginResponse
import com.example.graduation.data.models.postbody.LoginBody
import com.example.graduation.domain.repository.AuthRepository
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    private val TAG = "LoginUseCase"
    operator fun invoke(loginBody: LoginBody): Flow<Resource<LoginResponse>> = flow {
        try {
            emit(Resource.Loading())
            val loginResponse = repository.login(loginBody)
            Log.d(TAG, "invoke: Login use case ${loginResponse.isSuccessful}")
            if (loginResponse.isSuccessful && loginResponse.body() != null) {
                loginResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                Log.d(TAG, "invoke: Login use case errorBody ${loginResponse.errorBody()}")
                val errorString = loginResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8

                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: Error Login use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception Login use case ${e.localizedMessage}")
//            val errorMessage =
//                Constants.getErrorResponse(loginResponse.errorBody().toString()).message ?: ""
//            Log.e(TAG, "invoke: Error Login use case $errorMessage")
//            emit(Resource.Error(errorMessage))
            emit(
                Resource.Error(
                    e.localizedMessage?:""
                )
            )
        }
    }
}
