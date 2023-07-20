package com.example.mvp_android.network.retrofit

import com.example.mvp_android.network.model.quoteList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("quotes")
    suspend fun getQuotes() : Response<quoteList>
}