package com.example.exchangemany

import retrofit2.Call
import retrofit2.http.GET

//Создаем интерфейс для Ретрофита
interface InterfaceAPI {

    @GET("?get=rates&pairs=USDRUB,EURRUB&key=bd982b768a1686fafb5f467b34ddd2c2")
    fun  getKurs(): Call<KursValut>




}