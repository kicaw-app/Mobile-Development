package com.satriopndt.kicawcapstone.data.retrofit

import com.satriopndt.kicawcapstone.data.response.Login
import com.satriopndt.kicawcapstone.data.response.LoginResponse
import com.satriopndt.kicawcapstone.data.response.Register
import com.satriopndt.kicawcapstone.data.response.RegisterResponse
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface ApiService {

    @POST("users")
    suspend fun register(
        @Body requestBody: Register
    ): RegisterResponse

    @POST("users/login")
    suspend fun login(
        @Body requestBody: Login
    ): LoginResponse


}