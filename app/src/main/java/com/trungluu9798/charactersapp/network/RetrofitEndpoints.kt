package com.trungluu9798.charactersapp.network

import com.trungluu9798.charactersapp.model.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitEndPoints {

    @GET("/")
    abstract fun getData(
        @Query("q") query: String,
        @Query("format") format: String = "json"
    ): Call<Data>

}