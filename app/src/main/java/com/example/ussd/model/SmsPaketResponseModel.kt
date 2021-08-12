package com.example.ussd.model

data class SmsPaketResponseModel(
    val data: List<SmsPaketInfoModel>,
    val succes: Boolean
)
data class SmsPaketInfoModel(
    val paket_nomi: String,
    val info: String,
    val type: String
)