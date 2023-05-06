package com.example.graduation.domain.usecase.auth.forgetpassword

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.postbody.ForgetPasswordBody
import com.example.graduation.data.models.response.auth.ForgetPasswordResponse
import com.example.graduation.domain.repository.AuthRepository
import com.example.graduation.util.Resource
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class ForgetPasswordUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    private val TAG = "ForgetPasswordUseCase"
    operator fun invoke(forgetPasswordBody: ForgetPasswordBody): Flow<Resource<MainResponseModel<ForgetPasswordResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val myResponse = repository.forgetPassword(forgetPasswordBody)
            Log.d(TAG, "invoke: ForgetPassword use case ${myResponse.isSuccessful}")
            if (myResponse.isSuccessful && myResponse.body() != null) {
                myResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                Log.d(TAG, "invoke: ForgetPassword use case errorBody ${myResponse.errorBody()}")
                val errorString = myResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8

                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: Error ForgetPassword use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception ForgetPassword use case ${e.localizedMessage}")
            emit(
                Resource.Error(
                    e.localizedMessage?:""
                )
            )
        }
    }
}
