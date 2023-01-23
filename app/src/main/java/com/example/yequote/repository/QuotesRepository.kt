package com.example.yequote.repository

import android.util.Log
import com.example.yequote.data.model.Quotes
import com.example.yequote.di.ApiService
import javax.inject.Inject
import com.example.yequote.utils.Result
import okio.IOException


class QuotesRepository @Inject constructor(private val apiService: ApiService) {
    suspend fun getQuotes(): Result<Quotes> {
        return try {
            val response = apiService.getQuotes()
            if (response.isSuccessful) {
                Result.Success(response.body()!!)
            } else {
                Log.e(" quotesRepository", "Error getting quotes: ${response.code()}")
                Result.Error(IOException("Error code: ${response.code()}"))
            }
        } catch (e: Exception) {
            Log.e(" quotesRepository", "Error getting quotes: ${e.message}")
            Result.Error(e)
        }
    }
}
