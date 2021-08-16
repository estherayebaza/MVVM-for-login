package com.example.project2.models

import com.google.gson.annotations.SerializedName

data class RegistrationRequest (
    var name:String,
    var phoneNumber:String,
    var email:String,
    var nationality:String,
    var dateOfBirth:String,
    var password:String
        )
