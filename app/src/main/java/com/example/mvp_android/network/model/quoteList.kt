package com.example.mvp_android.network.model

import com.google.gson.annotations.SerializedName

data class quoteList (
    @SerializedName("quotes")
    val quotes :List<quote>,
)