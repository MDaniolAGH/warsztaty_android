package com.example.warsztat_mvvm.repository

import com.example.warsztat_mvvm.api.StaffListRetriever
import com.example.warsztat_mvvm.models.StaffMember
import retrofit2.Callback

class MainRepository(private val apiRetriever: StaffListRetriever) {

    fun getMedicalStaff(callback: Callback<List<StaffMember>>) {
       apiRetriever.getMedicalStaff(callback)
    }

    fun getMedicalStaffFromDB(callback: Callback<List<StaffMember>>) {
        //We present the data from local DB to immediaely show sth to the user
    }

    fun getMedicalStaffFromAPI(callback: Callback<List<StaffMember>>) {
        //We ask API for a data
    }
}