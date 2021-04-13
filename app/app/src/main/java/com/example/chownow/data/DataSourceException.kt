package com.example.chownow.data

open class DataSourceException(message: String? = null) : Exception(message)

class RemoteDataNotFoundException : DataSourceException("Data not found in remote data source")