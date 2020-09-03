package com.example.gdd_retrofit.pojo
import com.google.gson.annotations.SerializedName

data class PutUserBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String
)