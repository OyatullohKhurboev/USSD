package com.example.ussd.model

data class UssdResponseModel(
    val data: ArrayList<UssdInfoModel>,
    val succes: Boolean
)
data class UssdInfoModel(

    val name: String,
    val info: String
    )