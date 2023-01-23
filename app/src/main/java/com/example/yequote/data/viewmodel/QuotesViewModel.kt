package com.example.yequote.data.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.yequote.data.model.Quotes
import com.example.yequote.repository.QuotesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.yequote.utils.Result


@HiltViewModel
class QuotesViewModel @Inject constructor(private val repository: QuotesRepository): ViewModel() {

    private val _response : MutableLiveData<Quotes> = MutableLiveData()
    val quotesResponse : LiveData<Quotes>
        get() = _response

    private val _error : MutableLiveData<String> = MutableLiveData()
    val error : LiveData<String>
        get() = _error

    private fun getQuotes() = viewModelScope.launch {
        try {
            val quotesResult = repository.getQuotes()
            if (quotesResult is Result.Success) {
                _response.postValue(quotesResult.data!!)
            } else if (quotesResult is Result.Error) {
                _error.postValue("Error: ${quotesResult.exception.message}")
                Log.e(" quotesViewModel", "Error getting quotes: ${quotesResult.exception.message}")
            }
        } catch (e: Exception) {
            _error.postValue("Error: ${e.message}")
            Log.e(" quotesViewModel", "Error getting quotes: ${e.message}")
        }
    }


}