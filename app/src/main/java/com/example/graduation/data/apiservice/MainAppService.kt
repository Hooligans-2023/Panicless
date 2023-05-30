package com.example.graduation.data.apiservice

import com.example.graduation.data.models.postbody.CreateReadBody
import com.example.graduation.data.models.response.reading.ReadingResponse
import retrofit2.Response
import retrofit2.http.*


interface MainAppService {


    @POST("/reading/create-reading/")
    suspend fun createReading(
        @Body createReadBody: CreateReadBody
    ): Response<ReadingResponse>

    @DELETE("/reading/delete-reading/{id}/")
    suspend fun deleteReading(
        @Path("id") id: Int
    ): Response<Any>

    @GET("/reading/last-reading/")
    suspend fun getLastReading(
    ): Response<List<ReadingResponse>>

    @GET("/reading/list-reading/")
    suspend fun getListReading(
    ): Response<List<ReadingResponse>>

}