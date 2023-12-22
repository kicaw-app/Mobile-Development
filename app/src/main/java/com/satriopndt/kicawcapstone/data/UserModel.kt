package com.satriopndt.kicawcapstone.data

data class UserModel(
    var userId: String,
    var name: String,
    var token: String,
    var isLogin: Boolean = false
)