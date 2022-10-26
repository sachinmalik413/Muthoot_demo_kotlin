package com.example.muthootdemo2.states

sealed class NetworkResponseState {
    object Loading : NetworkResponseState()
    class Failure(val e: Throwable) : NetworkResponseState()
    class Success(val data: Any) : NetworkResponseState()
}