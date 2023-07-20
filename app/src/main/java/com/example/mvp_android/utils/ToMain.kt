package com.example.mvp_android.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun CoroutineScope.launchOnMain(call:()->Unit){
    launch (Dispatchers.Main){
        call.invoke()
    }
}