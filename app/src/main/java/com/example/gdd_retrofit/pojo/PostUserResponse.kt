package com.example.gdd_retrofit.pojo
import com.google.gson.annotations.SerializedName

data class PostUserResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("email")
        val email: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("username")
        val username: String
    )
}