package com.example.warsztat_mvvm.api

import com.example.warsztat_mvvm.models.StaffMember
import retrofit2.Call
import retrofit2.http.GET


interface MedicalListService {
    @GET("stafflist")
    fun retrieveMedicalStaff(): Call<List<StaffMember>>
}