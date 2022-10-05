package com.example.cryptoinfo.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoinfo.network.CryptoLabel
import com.example.cryptoinfo.network.GeckoApi
import kotlinx.coroutines.launch

enum class GeckoApiStatus { LOADING, ERROR, DONE }

class OverviewViewModel : ViewModel() {

    // Внутренние изменяемые данные, в которых хранится статус самого последнего запроса
    private val _status = MutableLiveData<GeckoApiStatus>()
    private val _labels: MutableLiveData<List<CryptoLabel>> by lazy {
        MutableLiveData<List<CryptoLabel>>().also {
            getCryptoLabels()
        }
    }

    // Внешние неизменяемые LiveData для статуса запроса
    val status: LiveData<GeckoApiStatus> = _status

    // Внешние неизменяемые LiveData для запроса лейблов
    val labels: LiveData<List<CryptoLabel>> = _labels


    fun getCryptoLabels() {
        viewModelScope.launch {
            _status.value = GeckoApiStatus.LOADING
            try{
                _labels.value = GeckoApi.retrofitService.getLabels()
                _status.value = GeckoApiStatus.DONE
            }
            catch (e: Exception){
                _status.value = GeckoApiStatus.ERROR
                _labels.value = listOf()
            }
        }
    }
}