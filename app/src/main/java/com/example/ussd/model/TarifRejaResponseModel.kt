package com.example.ussd.model

data class TarifRejaResponseModel(
    val data: ArrayList<TarifRejaInfoModel>,
    val success: Boolean
)

data class TarifRejaInfoModel (
    val tarif_nomi: String,
    val abonet_tolovi: String,
    val chiquvchi_ozbekiston: String,
    val ozbekiston_boyicha: String,
    val internet_paket: String,
    val type: String

    )