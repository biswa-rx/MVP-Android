package com.example.mvp_android.models

import com.example.mvp_android.contracts.MainActivityContract
import com.example.mvp_android.network.retrofit.ApiService
import java.lang.Exception
import javax.inject.Inject

class MainModel (private val apiService:ApiService): MainActivityContract.Model {
    override suspend fun fetchQuotes(
        onFinishListener: MainActivityContract.Model.OnFinishListener,
        random: String
    ) {
        onFinishListener.onLoading()
        try{
            val response = apiService.getQuotes()
            if(response.isSuccessful){
                response.body()?.let {
                    onFinishListener.onSuccess(it)
                }
            }else{
                onFinishListener.onError(response.errorBody().toString())
            }


        }catch (e: Exception){
            onFinishListener.onError(message = e.message.toString())
        }
    }


}