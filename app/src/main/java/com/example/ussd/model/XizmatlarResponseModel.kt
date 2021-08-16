package com.example.ussd.model


data class XizmatlarResponseModel(
    val data: ArrayList<XizmatInfoModel>,
    val succes: Boolean
)
data class XizmatInfoModel(

    val xizmat_nomi: String,
    val info: String
)