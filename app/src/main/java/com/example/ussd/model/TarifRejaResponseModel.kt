package com.example.ussd.model

data class TarifRejaResponseModel(
    val data: ArrayList<TarifRejaInfoModel>,
    val success: Boolean
)

data class TarifRejaInfoModel (
    val tarif_nomi: String,
    val tv_tolov : String,
    val abonent_tolovi: String,
    val tv_uzb_boyicha:String,
    val boyicha : String,
    val daqiqa: String,

    val type: String

    )