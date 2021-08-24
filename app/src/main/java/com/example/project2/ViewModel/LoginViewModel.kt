package com.example.project2.ViewModel//package com.example.project2.ViewModel
//
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.viewModelScope
//import com.example.project2.Repository.UserRepository
//import com.example.project2.models.LoginRequest
//import com.example.project2.models.LoginResponse
//import com.example.project2.models.RegistrationResponse
//import kotlinx.coroutines.launch
//
//class LoginViewModel {
//    var userRepository = UserRepository()
//    var loginResponseLiveData = MutableLiveData<LoginResponse>()
//    var loginErrorLiveData = MutableLiveData<String>()
//
//    fun loginStudent(loginRequest: LoginRequest) {
//        viewModel.launch {
//            var response = userRepository.loginStudent(loginRequest)
//            if (response.isSuccessful) {
//                loginResponseLiveData.postValue(response.
//
//                body())
//            }
//            else{
//                loginErrorLiveData.postValue(response.errorBody()?.string())
//
//            }
//        }
//}}