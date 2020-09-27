package com.example.warsztat_mvvm.network

import com.example.warsztat_mvvm.model.Doctor
import retrofit2.Call
import retrofit2.http.GET

interface DoctorsService {

    @GET("stafflist")
    fun getDoctorsList(): Call<List<Doctor>>
}