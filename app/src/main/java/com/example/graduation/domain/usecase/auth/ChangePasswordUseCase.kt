package com.example.graduation.domain.usecase.auth

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.postbody.ChangePasswordBody
import com.example.graduation.data.models.response.auth.ChangePasswordResponse
import com.example.graduation.domain.repository.AuthRepository
import com.example.graduation.util.Resource
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class ChangePasswordUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    private val TAG = "LoginUseCase"
    operator fun invoke(changePasswordBody: ChangePasswordBody): Flow<Resource<MainResponseModel<ChangePasswordResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val mainResponse = repository.changePassword(changePasswordBody)
            Log.d(TAG, "invoke: ChangePassword use case ${mainResponse.isSuccessful}")
            if (mainResponse.isSuccessful && mainResponse.body() != null) {
                mainResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                Log.d(TAG, "invoke: ChangePassword use case errorBody ${mainResponse.errorBody()}")
                val errorString = mainResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8

                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: ChangePassword Login use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception ChangePassword use case ${e.localizedMessage}")
            emit(
                Resource.Error(
                    e.localizedMessage?:""
                )
            )
        }
    }
}
