package com.example.gdd_retrofit.pojo
import com.google.gson.annotations.SerializedName

data class PutUserBody(
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String
)