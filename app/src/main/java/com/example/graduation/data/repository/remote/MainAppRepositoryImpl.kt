package com.example.graduation.data.repository.remote

import com.example.graduation.data.apiservice.MainAppService
import com.example.graduation.data.models.postbody.CreateReadBody
import com.example.graduation.data.models.response.reading.ReadingResponse
import com.example.graduation.domain.repository.MainAppRepository
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

class MainAppRepositoryImpl @Inject constructor(
    private val api: MainAppService
) : MainAppRepository {

    override suspend fun createReading(createReadBody: CreateReadBody): Response<ReadingResponse> =
        api.createReading(createReadBody)

    override suspend fun deleteReading(
        id: Int
    ): Response<Any> = api.deleteReading(id)

    override suspend fun getLastReading(
    ): Response<List<ReadingResponse>> = api.getLastReading()

    override suspend fun getListReading(
    ): Response<List<ReadingResponse>> = api.getListReading()
}