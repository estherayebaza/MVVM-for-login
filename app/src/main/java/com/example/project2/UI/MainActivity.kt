package com.example.project2
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.project2.API.Apiclient
import com.example.project2.UI.CoursesActivity
import com.example.project2.ViewModel.UserViewModel
import com.example.project2.api.ApiInterface
import com.example.project2.databinding.ActivityMainBinding
import com.example.project2.models.RegistrationRequest
import com.example.project2.models.RegistrationResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val userViewModel:UserViewModel by viewModels()
    lateinit var sharedPrefs:SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs=getSharedPreferences(Constants.PREFS_FILE, Context.MODE_PRIVATE)

        clickRegister()
        setUpSpinner()
        redirectUser()
    }
    fun redirectUser(){
        var token=sharedPrefs.getString(Constants.ACCESS_TOKEN,Constants.EMPTY_STRING)
        if(token!!.isEmpty()){
            startActivity(Intent(baseContext,CoursesActivity::class.java))
        }

    }
    fun setUpSpinner(){

        var nationalities= arrayListOf("Kenyan","Rwandan","SouthSudanese","Sudanese","Rwandan","Ugandan")
        var nationalitiesAdapter=ArrayAdapter(baseContext,android.R.layout.simple_spinner_dropdown_item,nationalities)
        nationalitiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spNationality.adapter=nationalitiesAdapter

    }
        fun clickRegister() {
            binding.btnButton2.setOnClickListener {

                var button = binding.btnButton2.text.toString()
                if (button.isEmpty()) {
                    binding.btnButton2.setError("enter name")
                }

                var nationality = binding.spNationality.selectedItem.toString()

                var name = binding.tlName.text.toString()
                if (name.isEmpty()) {
                    binding.tlName.setError("enter Date of birth")
                }

                var dob = binding.etDob.text.toString()
                if (dob.isEmpty()) {
                    binding.etDob.setError("enter Date of birth")
                }

                var password = binding.etPassword.text.toString()
                if (password.isEmpty()) {
                    binding.etPassword.setError("Enter password")
                }
                var phoneNumber = binding.etPhone.text.toString()
                if (phoneNumber.isEmpty()) {
                    binding.etPhone.setError("Enter phone number")
                }
                var email = binding.etEmail.text.toString()
                if (email.isEmpty()) {
                    binding.etEmail.setError("enter email")
                }

                var regRequest = RegistrationRequest(
                    name = name, password = password, phoneNumber = phoneNumber, email = email,
                    dateOfBirth = dob, nationality = nationality
                )
                userViewModel.registerStudent(regRequest)
            }
        }
    override fun onResume(){
        super.onResume()
        userViewModel.regResponseLiveData.observe(this,{regResponse->
            if (!regResponse.studentId.isNullOrEmpty()){
                Toast.makeText(baseContext,"registration successfull",Toast.LENGTH_LONG).show()
            }
        })
        userViewModel.regErrorLiveData.observe(this,{ error->
            Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
        })

    }
}














