package com.example.project2.UI

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.project2.R
import com.example.project2.ViewModel.UserViewModel
import com.example.project2.databinding.ActivityLogInBinding
import com.example.project2.models.LoginRequest

class LogIn : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    val userViewModel:UserViewModel by viewModels()
    lateinit var sharedPrefs:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs=getSharedPreferences("project2", Context.MODE_PRIVATE)

        binding.btnLogin.setOnClickListener {
 binding.progressBar2.visibility= View.VISIBLE

            val email = binding.tilEmail.text.toString()
            if (email.isEmpty()) {
                binding.tilEmail.setError("enter name")
            }
            val pass = binding.tillPassword.text.toString()
            if (pass.isEmpty()) {
                binding.tillPassword.setError("enter name")
            }
            val logRequest =
                LoginRequest(
                    email = email, password = pass
                )
            val intent = Intent(baseContext, CoursesActivity::class.java)
            startActivity(intent)

            userViewModel.loginStudent(logRequest)

        }
    }

        override fun onResume(){
        super.onResume()
        userViewModel.loginResponseLiveData.observe(this,{ logResponse->
            if (!logResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext,"registration successfull",Toast.LENGTH_LONG).show()
                var editor=sharedPrefs.edit()
                editor.putString("ACCESS_TOKEN",logResponse.accessToken)
                editor.putString("STUDENTS_ID",logResponse.studentId)
                editor.apply()

            }

        })
        userViewModel.loginErrorLiveData.observe(this,{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })
            binding.progressBar2.visibility= View.GONE
}}






//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityLogInBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        binding.btnLogin.setOnClickListener {
//            var logInRequest = LoginRequest(binding.tilEmail.text.toString(),
//                binding.tillPassword.text.toString())
//            userViewModel.loginStudent(logInRequest)
//        }
//    }
//    override fun onResume(){
//        super.onResume()
//        userViewModel.loginResponseLiveData.observe(this,{ logResponse->
//            if (!logResponse.studentId.isNullOrEmpty()){
//                Toast.makeText(baseContext,"registration successfull",Toast.LENGTH_LONG).show()
//            }
//
//        })
//        userViewModel.loginErrorLiveData.observe(this,{ error->
//            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
//        })

//override fun onResume(){
//    binding.btnLogin.setOnClickListener {
//        var logInRequest = LoginRequest(binding.tilEmail.text.toString(),
//            binding.tillPassword.text.toString())
//        userViewModel.loginStudent(logInRequest)
//    }
//}
//
//    }




