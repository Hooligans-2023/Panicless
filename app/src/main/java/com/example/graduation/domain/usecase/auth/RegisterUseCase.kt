package com.example.graduation.domain.usecase.auth


import android.util.Log
import com.example.graduation.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.postbody.RegisterBody
import com.example.graduation.data.models.response.auth.RegisterResponse
import com.example.graduation.domain.repository.AuthRepository
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class RegisterUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    private val TAG = "com.example.graduation.domain.usecase.auth.RegisterUseCase"
    operator fun invoke(registerBody: RegisterBody): Flow<Resource<RegisterResponse>> = flow {
        try {
            emit(Resource.Loading())
            val registerResponse = repository.register(registerBody)
            if (registerResponse.isSuccessful && registerResponse.body() != null) {
                registerResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                val errorString = registerResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8
                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: Error Register use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception Register use case ${e.localizedMessage}")
            emit(
                Resource.Error(
                    e.localizedMessage?:""
                )
            )
        }
    }
}