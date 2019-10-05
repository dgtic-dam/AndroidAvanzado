package com.cybertech.webservicesexample.models


import com.google.gson.annotations.SerializedName

data class MoviesList(
    @SerializedName("Response")
    val response: String,
    @SerializedName("Search")
    val search: ArrayList<Search>,
    val totalResults: String
)