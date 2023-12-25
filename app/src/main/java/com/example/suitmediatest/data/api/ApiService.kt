package com.example.suitmediatest.data.api

import com.example.suitmediatest.data.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUser(): Call<ArrayList<UserResponse>>
}