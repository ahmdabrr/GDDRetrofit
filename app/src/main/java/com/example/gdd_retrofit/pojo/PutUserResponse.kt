package com.example.gdd_retrofit.pojo
import com.google.gson.annotations.SerializedName

data class PutUserResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("result")
    val result: String
) {
    data class Data(
        @SerializedName("CreatedAt")
        val createdAt: String,
        @SerializedName("DeletedAt")
        val deletedAt: Any,
        @SerializedName("email")
        val email: String,
        @SerializedName("hash_password")
        val hashPassword: String,
        @SerializedName("ID")
        val iD: Int,
        @SerializedName("password")
        val password: String,
        @SerializedName("UpdatedAt")
        val updatedAt: String,
        @SerializedName("username")
        val username: String
    )
}