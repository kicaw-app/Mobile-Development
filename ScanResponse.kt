package com.satriopndt.kicawcapstone.data.response

import com.google.gson.annotations.SerializedName

data class ScanResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Status? = null
)

data class DataScan(

	@field:SerializedName("bird_types_prediction")
	val birdTypesPrediction: String? = null,

	@field:SerializedName("confidence")
	val confidence: Any? = null
)

data class Status(

	@field:SerializedName("code")
	val code: Int? = null,

	@field:SerializedName("message")
	val message: String? = null
)
