package com.example.yequote.repository

import com.example.yequote.di.ApiService
import javax.inject.Inject

class QuotesRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getQuotes() =
        apiService.getQuotes()
}