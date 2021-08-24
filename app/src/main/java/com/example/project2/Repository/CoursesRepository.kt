package com.example.project2.Repository

import com.example.project2.API.Apiclient
import com.example.project2.api.ApiInterface
import com.example.project2.models.CoursesResponse
import com.example.project2.models.SessionManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class CoursesRepository {
    lateinit var sessionManager: SessionManager
    var apiInterface = Apiclient.buildApiClient(ApiInterface::class.java)
    suspend fun courses(): Response<List<CoursesResponse>> =
        withContext(Dispatchers.IO){
            var response=apiInterface.studentCourses(token="Bearer ${sessionManager.fetchAuthentication()}")
            return@withContext response

        }
}





