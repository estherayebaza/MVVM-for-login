package com.example.project2.api

import com.example.project2.models.LoginRequest
import com.example.project2.models.LoginResponse
import com.example.project2.models.RegistrationResponse
import com.example.project2.models.RegistrationRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
    @POST("/students/register")
    fun registerStudent(@Body registrationRequest: RegistrationRequest):Response<RegistrationResponse>
    @POST("/students/login")
    fun loginStudent(@Body loginRequest: LoginRequest):Response<LoginResponse>
}

