package com.mhl.meditation.retroshit

import com.mhl.meditation.recadapters.feel
import com.mhl.meditation.recadapters.login
import com.mhl.meditation.recadapters.quotes
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiRet{
    @POST("user/login")
    fun getAuth(@Body hashMap: HashMap<String, String>):Call<login>
    @GET("quotes")
    fun getQuotes():Call<quotes>
    @GET("feelings")
    fun getFeelings():Call<feel>
}