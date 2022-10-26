package com.example.muthootdemo2.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.main.usecases.MainUseCase
import com.example.muthootdemo2.states.NetworkResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val useCase: MainUseCase
) : ViewModel() {

    private val myResponse: MutableStateFlow<NetworkResponseState> =
        MutableStateFlow(NetworkResponseState.Loading)

    val myResponseFlow: StateFlow<NetworkResponseState> = myResponse

    fun fetchApi() {
        myResponse.value = NetworkResponseState.Loading
        viewModelScope.launch {
            kotlin.runCatching {
                useCase.fetchApi()
            }
                .onSuccess {
                    myResponse.value = NetworkResponseState.Success(it)
                }
                .onFailure {
                    myResponse.value = NetworkResponseState.Failure(it)
                }
        }
    }

}