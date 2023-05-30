package com.example.graduation.domain.usecase.main_app

import android.util.Log
import com.example.graduation.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.graduation.data.models.postbody.CreateReadBody
import com.example.graduation.data.models.response.reading.ReadingResponse
import com.example.graduation.domain.repository.MainAppRepository
import com.example.graduation.util.getErrorResponse
import javax.inject.Inject

class DeleteReadingUseCase @Inject constructor(
    private val repository: MainAppRepository
) {
    private val TAG = "DeleteReadingUseCase"
    operator fun invoke(id: Int): Flow<Resource<Any>> = flow {
        try {
            emit(Resource.Loading())
            val createReadBodyResponse = repository.deleteReading(id)
            Log.d(TAG, "invoke: DeleteReading use case ${createReadBodyResponse.isSuccessful}")
            if (createReadBodyResponse.isSuccessful && createReadBodyResponse.body() != null) {
                createReadBodyResponse.body()?.let { response ->
                    emit(Resource.Success(response))
                }
            } else {
                Log.d(TAG, "invoke: DeleteReading use case errorBody ${createReadBodyResponse.errorBody()}")
                val errorString = createReadBodyResponse.errorBody()?.byteStream()?.bufferedReader().use { it?.readText() }  // defaults to UTF-8

                val errorMessage =
                    getErrorResponse(errorString!!).message ?: ""
                Log.e(TAG, "invoke: DeleteReading Login use case $errorMessage")
                emit(Resource.Error(errorMessage))
            }

        } catch (e: Exception) {
            Log.e(TAG, "invoke: Exception DeleteReading use case ${e.localizedMessage}")
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
