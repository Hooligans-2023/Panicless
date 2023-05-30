package com.example.graduation.domain.repository

import com.example.graduation.data.models.postbody.CreateReadBody
import com.example.graduation.data.models.response.reading.ReadingResponse
import retrofit2.Response


interface MainAppRepository {

    suspend fun createReading(
         createReadBody: CreateReadBody
    ): Response<ReadingResponse>


    suspend fun deleteReading(id: Int): Response<Any>
    suspend fun getLastReading(): Response<List<ReadingResponse>>
    suspend fun getListReading(): Response<List<ReadingResponse>>
}