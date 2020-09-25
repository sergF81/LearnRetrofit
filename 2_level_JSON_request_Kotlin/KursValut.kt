package com.example.exchangemany

import com.google.gson.annotations.SerializedName

//Класс для получения даных из JSON ответа
data class KursValut (

    val status : Int,
    val message : String,
    val data : Data
)

//Вложенный класс в KursValute
data class Data (
@SerializedName("USDRUB")
    val usdrub : Double,
@SerializedName("EURRUB")
    val eurrub : Double
)