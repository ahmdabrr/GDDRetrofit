package com.example.gdd_retrofit.pojo
import com.google.gson.annotations.SerializedName

data class PostUserErrorResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)