package com.example.lovelink.network

import com.example.lovelink.models.LoginResponse
import com.example.lovelink.models.RegistrationData
import com.example.lovelink.models.RegistrationResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

object RetrofitClient {
    private const val BASE_URL = "http://192.168.205.86:8000/api/"

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

    interface ApiService {
        @POST("login") // Laravel API endpoint
        suspend fun login(@Body request: LoginRequest): Response<LoginResponse>


        @POST("register") // Laravel API endpoint
        suspend fun registerUser(@Body request: RegistrationData): Response<RegistrationResponse>
    }
}