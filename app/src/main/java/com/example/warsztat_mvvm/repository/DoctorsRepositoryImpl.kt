package com.example.warsztat_mvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.warsztat_mvvm.model.Doctor
import com.example.warsztat_mvvm.network.DoctorsService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DoctorsRepositoryImpl() : DoctorsRepository {

    private val api: DoctorsService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://medicalstaffapi-agh.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(DoctorsService::class.java)
    }

    override fun getDoctors(): LiveData<List<Doctor>> {
        val doctorsLiveData = MutableLiveData<List<Doctor>>()

        api.getDoctorsList().enqueue(object: Callback<List<Doctor>> {
            override fun onFailure(call: Call<List<Doctor>>, t: Throwable) {
                doctorsLiveData.value = emptyList()
            }

            override fun onResponse(call: Call<List<Doctor>>, response: Response<List<Doctor>>) {
                doctorsLiveData.value = response.body()
            }
        })
        return doctorsLiveData
    }
}