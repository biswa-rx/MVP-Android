package com.example.mvp_android.presenter

import com.example.mvp_android.contracts.MainActivityContract
import com.example.mvp_android.network.model.quoteList
import com.example.mvp_android.utils.launchOnMain
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainPresenter(
    private val view: MainActivityContract.View,
    private val model: MainActivityContract.Model
) : MainActivityContract.Presenter,MainActivityContract.Model.OnFinishListener {
    val scope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    override fun getUniversity(country: String) {
        scope.launch {
            model.fetchQuotes(this@MainPresenter,"Random")
        }
    }

    override fun onDestroy() {
        scope.cancel()
    }

    override fun onLoading() {
        scope.launchOnMain {
            view.onLoading()
        }
    }

    override fun onError(message: String) {
        scope.launchOnMain {
            view.onError(message)
        }

    }

    override fun onSuccess(list: quoteList) {
        scope.launchOnMain {
            view.onSuccess(list)
        }
    }


}