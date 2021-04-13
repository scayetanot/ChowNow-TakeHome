package com.example.chownow.data

sealed class ResultLocations<out T : Any> {
    data class Success<out T : Any>(val data: T) : ResultLocations<T>()
    data class Error(val exception: Exception) : ResultLocations<Nothing>()
}