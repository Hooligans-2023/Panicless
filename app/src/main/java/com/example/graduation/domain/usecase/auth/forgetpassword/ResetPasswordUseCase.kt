package com.example.graduation.domain.usecase.auth.forgetpassword

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.postbody.ResetPasswordBody
import com.example.graduation.data.models.response.auth.NewPasswordResponse
import com.example.graduation.domain.repository.AuthRepository
import com.example.graduation.util.Resource
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class ResetPasswordUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    private val TAG = "ResetPasswordUseCase"
    operator fun invoke(resetPasswordBody: ResetPasswordBody): Flow<Resource<MainResponseModel<NewPasswordResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val myResponse = repository.resetPassword(resetPasswordBody)
            Log.d(TAG, "invoke: ResetPassword use case ${myResponse.isSuccessful}")
            if (myResponse.isSuccessful && myResponse.body() != null) {
                myResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                Log.d(TAG, "invoke: ResetPassword use case errorBody ${myResponse.errorBody()}")
                val errorString = myResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8

                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: Error ResetPassword use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception ResetPassword use case ${e.localizedMessage}")
            emit(
                Resource.Error(
                    e.localizedMessage?:""
                )
            )
        }
    }
}
