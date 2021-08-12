package com.example.ussd.model

data class UssdResponseModel(
    val `data`: List<UssdInfoModel>,
    val succes: Boolean
)
data class UssdInfoModel(

    val name: String,
    val info: String,
    val type: String
)