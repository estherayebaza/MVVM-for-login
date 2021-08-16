package com.example.project2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.project2.API.Apiclient
import com.example.project2.api.ApiInterface
import com.example.project2.models.LoginRequest
import com.example.project2.models.LoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LogInActivity : AppCompatActivity() {
    lateinit var tilEmail: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

         tilEmail=findViewById(R.id.tilEmail)
         etPassword= findViewById(R.id.etPassword)
             btnLogin=findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            var email = tilEmail.text.toString()
            if (email.isEmpty()) {
                tilEmail.setError("enter your email")
            }
            var password = etPassword.text.toString()
            if (password.isEmpty()) {
                etPassword.setError("Enter your password")
            }
            var logRequest = LoginRequest(email = email, password = password)
            var retrofit = Apiclient.buildApiClient(ApiInterface::class.java)
            var request = retrofit.loginStudent(logRequest)
request.enqueue(object : Callback<LoginResponse>


          {
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {
                        Toast.makeText(baseContext, "Your log in is successful", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        Toast.makeText(
                            baseContext,
                            response.errorBody()?.string(),
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()

                }
            })

        }}
}



