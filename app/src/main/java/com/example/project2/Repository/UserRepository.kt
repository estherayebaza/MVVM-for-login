package com.example.project2.Repository

import com.example.project2.API.Apiclient
import com.example.project2.api.ApiInterface
import com.example.project2.models.LoginRequest
import com.example.project2.models.LoginResponse
import com.example.project2.models.RegistrationRequest
import com.example.project2.models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var apiInterface = Apiclient.buildApiClient(ApiInterface::class.java)

    suspend fun registerStudent(registrationRequest: RegistrationRequest):
            Response<RegistrationResponse> = withContext(Dispatchers.IO){
        var response = apiInterface.registerStudent(registrationRequest)
        return@withContext response
    }

    suspend fun loginStudent(logInRequest: LoginRequest):Response<LoginResponse> =
        withContext(Dispatchers.IO){
            var response = apiInterface.loginStudent(logInRequest)
            return@withContext response
        }
}