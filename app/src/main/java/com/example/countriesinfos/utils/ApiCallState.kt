package com.example.countriesinfos.utils

sealed class ApiCallState<T> (val message: String? = null) {

    class Success<T> : ApiCallState<T>()
    class Error<T>(message: String?) : ApiCallState<T>(message = null)
    class Loading<T>: ApiCallState<T>()
}