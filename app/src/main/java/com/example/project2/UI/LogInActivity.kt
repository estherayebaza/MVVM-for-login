package com.example.project2.UI
//
//import android.content.Context
//import android.content.Intent
//import android.content.SharedPreferences
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.EditText
//import android.widget.Toast
//import androidx.activity.viewModels
//import com.example.project2.API.Apiclient
//import com.example.project2.R
//import com.example.project2.ViewModel.LoginViewModel
//import com.example.project2.api.ApiInterface
//import com.example.project2.databinding.ActivityLogInBinding
//import com.example.project2.databinding.ActivityMainBinding
//import com.example.project2.models.LoginRequest
//import com.example.project2.models.LoginResponse
//import com.example.project2.models.RegistrationRequest
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//class LogInActivity : AppCompatActivity() {
//    lateinit var binding: ActivityLogInBinding
//    val loginViewModel: LoginViewModel by viewModels()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(binding.root)
//
//        binding = ActivityLogInBinding.inflate(layoutInflater)
//        setContentView(binding.root)
////        Login()
////        setUpSpinner()
//    }
//    fun Login(){
//
//binding.btnLogin.setOnClickListener {
//
//}
//        var email=binding.tilEmail.text.toString()
//        var password=binding.tillPassword.text.toString()
//        var logRequest=LoginRequest(password=password,email = email)
//        LoginViewModel.loginStudent(logRequest)
//
//
//    }    }
//override fun onResume(){
//        super.onResume()
//        LoginViewModel.logInLiveData.observe(this, { logInResponse->
//            Toast.makeText(baseContext, logInResponse.message, Toast.LENGTH_LONG).show()
//
//        })
//
//        LoginViewModel.logInFailedLiveData.observe(this, {error->
//            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//        })
//        val intent = Intent(baseContext, CoursesActivity::class.java)
//        startActivity(intent)
//    }}



//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    binding = ActivityLogInBinding.inflate(layoutInflater)
//    setContentView(binding.root)
//
//        binding.btnLogin.setOnClickListener {
//            var loginRequest = LoginRequest(binding.tilEmail.text.toString(),
//                var
//        }
//    }

//    override fun onResume(){
//        super.onResume()
//        LoginViewModel.logInLiveData.observe(this, { logInResponse->
//            Toast.makeText(baseContext, logInResponse.message, Toast.LENGTH_LONG).show()
//
//        })
//
//        LoginViewModel.logInFailedLiveData.observe(this, {error->
//            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
//        })
//        val intent = Intent(baseContext, CoursesActivity::class.java)
//        startActivity(intent)
//    }}


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.project2.ViewModel.UserViewModel
import com.example.project2.databinding.ActivityLogInBinding
import com.example.project2.models.LoginRequest


class LogIn : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnLogin.setOnClickListener {
            var logInRequest = LoginRequest(binding.tilEmail.text.toString(),
                binding.tillPassword.text.toString())
            userViewModel.loginStudent(logInRequest)
        }
    }
    override fun onResume(){
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this,{ logResponse->
            if (!logResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext,"registration successfull",Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.loginErrorLiveData.observe(this,{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })

    }

}


