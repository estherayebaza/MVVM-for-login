package com.example.project2.Repository

import com.example.project2.API.Apiclient
import com.example.project2.api.ApiInterface
import com.example.project2.models.RegistrationRequest
import com.example.project2.models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    var retrofit=Apiclient.buildApiClient(ApiInterface::class.java)
   suspend fun registerUser(registrationRequest: RegistrationRequest):Response<RegistrationResponse> =
    withContext(Dispatchers.IO){
        var response=retrofit.registerStudent(registrationRequest)
return@withContext response    }

}