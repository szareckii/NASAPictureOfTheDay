package com.szareckii.nasapictureoftheday.ui.picture

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IPictureOfTheDayAPI {

    @GET("planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey: String): Call<PODServerResponseData>
}