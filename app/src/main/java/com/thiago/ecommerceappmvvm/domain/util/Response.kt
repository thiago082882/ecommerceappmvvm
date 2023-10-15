package com.thiago.ecommerceappmvvm.domain.util


import kotlin.Exception

sealed class Response<out T>{
    object Loading : Response<Nothing>()
    data class  Success<out T>(val data:T) : Response<Nothing>()

    data class  Failure<out T>(val exception:Exception) : Response<T>()


}
