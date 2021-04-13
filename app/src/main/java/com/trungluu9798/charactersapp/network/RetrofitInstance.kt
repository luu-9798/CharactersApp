package com.trungluu9798.charactersapp.network

import com.trungluu9798.charactersapp.model.Data
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {
    private val endpoint: RetrofitEndPoints

    init {
        endpoint = createEndPoint(getInstance())
    }

    private fun getInstance(): Retrofit {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    fun createEndPoint(retrofit: Retrofit): RetrofitEndPoints {
        return retrofit.create(RetrofitEndPoints::class.java)
    }

    fun getData(query: String): Call<Data> {
        return endpoint.getData(query = query)
    }

    companion object {
        private const val BASE_URL = "https://api.duckduckgo.com"
    }
}