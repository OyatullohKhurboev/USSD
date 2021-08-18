package com.example.ussd.model

data class TarifRejaResponseModel(
    val data: ArrayList<TarifRejaInfoModel>,
    val success: Boolean
)

data class TarifRejaInfoModel (
    val tarif_nomi: String,
    val abonet_tolovi: String,
    val daqiqa: String,
    val sms: String,
    val internet_paket: String,
    val type: String

    )