package com.example.gdd_retrofit.pojo


import com.google.gson.annotations.SerializedName

data class PostUserBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("username")
    val username: String
)