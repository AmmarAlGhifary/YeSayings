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

@HiltViewModel
class QuotesViewModel @Inject constructor(private val repository: QuotesRepository): ViewModel() {

    val _response : MutableLiveData<Quotes> = MutableLiveData()
    val quotesResponse : LiveData<Quotes>
        get() = _response

    private fun getQuotes() = viewModelScope.launch {
        repository.getQuotes().let { response ->
            if (response.isSuccessful) {
                _response.postValue(response.body())
            } else {
                Log.d("response", "error : ${response.code()}")
            }
        }
    }
}