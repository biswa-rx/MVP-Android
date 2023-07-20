package com.example.mvp_android.contracts

import com.example.mvp_android.network.model.quoteList

interface MainActivityContract {

    interface View {
        fun onLoading()
        fun onSuccess(list: quoteList)
        fun onError(message: String)
    }

    interface Presenter {
        fun getUniversity(country: String)
        fun onDestroy()
    }


    interface Model {
        interface OnFinishListener {
            fun onLoading()
            fun onError(message: String)
            fun onSuccess(list: quoteList)
        }

        suspend fun fetchQuotes(onFinishListener: OnFinishListener, random: String)
    }
}
