package com.example.yequote.di

import com.example.yequote.data.model.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET
    suspend fun getQuotes() : Response<Quotes>
}