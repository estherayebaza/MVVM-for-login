package com.example.project2.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.project2.API.Apiclient.retrofit
import com.example.project2.Repository.UserRepository
import com.example.project2.models.LoginRequest
import com.example.project2.models.LoginResponse
import com.example.project2.models.RegistrationRequest
import com.example.project2.models.RegistrationResponse
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var userRepository=UserRepository()
    var regResponseLiveData=MutableLiveData<RegistrationResponse>()
    var regErrorLiveData=MutableLiveData<String>()
    var loginResponseLiveData= MutableLiveData<LoginResponse>()
    var loginErrorLiveData=MutableLiveData<String>()
    fun registerStudent(registrationRequest: RegistrationRequest){
        viewModelScope.launch {
            var response=userRepository.registerStudent(registrationRequest)
            if(response.isSuccessful){
                regResponseLiveData.postValue(response
                    .body())
        }
            else{
                regErrorLiveData.postValue(response.errorBody()?.string())

            }            }
    }
    fun loginStudent(loginRequest: LoginRequest) {
        viewModelScope.launch {
            var response = userRepository.loginStudent(loginRequest)
            if (response.isSuccessful) {
                loginResponseLiveData.postValue(response.

                body())
            }
            else{
                loginErrorLiveData.postValue(response.errorBody()?.string())

            }
        }
    }

}