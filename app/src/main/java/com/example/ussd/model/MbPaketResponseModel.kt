package com.example.ussd.model

data class MbPaketResponseModel(
    val `data`: List<MbPaketInfoModel>,
    val succes: Boolean
)
data class MbPaketInfoModel(
    val info: String,
    val paket_nomi: String,
    val type: String
)