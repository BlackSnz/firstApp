package com.example.test2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersListInterface {
    @GET("/api/users/{user}")
    fun getUser(@Path("user") user: String): Call<UserData>

}