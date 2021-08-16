package com.example.ussd.model


data class DaqiqaResponseModel(
    val data: ArrayList<DaqiqaInfoModel>,
    val succes: Boolean,
)

data class DaqiqaInfoModel(
    val name: String,
    val tv_narxi: String,
    val narxi: String,
    val tv_muddat: String,
    val mudat: String,
    val Faollashtirish: String,
    val type: String,


    )