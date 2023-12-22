package com.satriopndt.kicawcapstone.data.response

import com.google.gson.annotations.SerializedName

data class RegisterResponse(

	@field:SerializedName("data")
	val data: Data
)

data class Data(

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("email")
	val email: String,

	@field:SerializedName("username")
	val username: String
)

data class Register(
	val name: String,
	val username: String,
	val email: String,
	val password: String
)
