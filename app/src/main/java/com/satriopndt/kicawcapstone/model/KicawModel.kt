package com.satriopndt.kicawcapstone.model

import java.util.Date

data class KicawModel (
    val id: Long,
    val name: String,
    val photoUrl: Int,
    val price: Int,
    val type: String,
    val description: String,
)

//data class KicawHistory(
//    val id: Long,
//    val photoUrl: Int,
//    val title,
//    val date,
//)

data class ForumModel (
    val id: Long,
    val title: String,
    val message: String,
    val time: String,
)