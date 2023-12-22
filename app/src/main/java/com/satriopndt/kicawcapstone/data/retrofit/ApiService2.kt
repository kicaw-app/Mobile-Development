package com.satriopndt.kicawcapstone.data.retrofit

import com.satriopndt.kicawcapstone.data.response.Register
import com.satriopndt.kicawcapstone.data.response.RegisterResponse
import com.satriopndt.kicawcapstone.data.response.ScanResponse
import okhttp3.MultipartBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface ApiService2 {

    @Multipart
    @POST("/prediction")
    suspend fun prediction(
        @Part image: MultipartBody.Part
    ): ScanResponse
}