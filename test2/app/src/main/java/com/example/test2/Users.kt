package com.example.test2

import com.google.gson.annotations.SerializedName

data class UserData(
    val usersParsed: UsersParsed,
    val addParsed: AddParsed
)
data class UsersParsed(
    var id: Long,
    var email: String,
    @SerializedName("first_name")
    var firstName: String,
    @SerializedName("last_name")
    var lastName: String,
    var avatar: String
)

data class AddParsed(
    var company: String,
    var ulr: String,
    var text: String
)
