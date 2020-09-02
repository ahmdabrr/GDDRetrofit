package com.example.gdd_retrofit.network
import com.example.gdd_retrofit.pojo.*
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET("user/{id}")
    fun getUserById(@Path("id") id: String): Call<GetUserById>

    @POST("user/register")
    fun addUser(@Body body: PostUserBody) : Call<PostUserResponse>

    @PUT("user/{id}")
    fun updateUser(@Body body: PutUserBody, @Path("id") id: String) : Call<PutUserResponse>

    @POST("user/login")
    fun loginUser(@Body body: LoginUserBody) : Call<LoginUserResponse>

}