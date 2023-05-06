package com.example.graduation.domain.usecase.auth

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.MainResponseModel
import com.example.graduation.data.models.response.auth.DeleteAccountResponse
import com.example.graduation.domain.repository.AuthRepository
import com.example.graduation.util.Resource
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class DeleteAccountUseCase @Inject constructor(
    private val repository: AuthRepository
) {
    private val TAG = "DeleteAccountUseCase"
    operator fun invoke(): Flow<Resource<MainResponseModel<DeleteAccountResponse>>> = flow {
        try {
            emit(Resource.Loading())
            val myResponse = repository.deleteAccount()
            Log.d(TAG, "invoke: DeleteAccount use case ${myResponse.isSuccessful}")
            if (myResponse.isSuccessful && myResponse.body() != null) {
                myResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                Log.d(TAG, "invoke: DeleteAccount use case errorBody ${myResponse.errorBody()}")
                val errorString = myResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8

                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: Error DeleteAccount use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception DeleteAccount use case ${e.localizedMessage}")
            emit(
                Resource.Error(
                    e.localizedMessage?:""
                )
            )
        }
    }
}
