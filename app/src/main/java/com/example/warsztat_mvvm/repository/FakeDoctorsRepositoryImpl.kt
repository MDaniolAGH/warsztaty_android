package com.example.warsztat_mvvm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.warsztat_mvvm.model.Doctor

class FakeDoctorsRepositoryImpl : DoctorsRepository {

    override fun getDoctors(): LiveData<List<Doctor>> = MutableLiveData(listOf(Doctor(name = "Arek Biela", specialization = "Kotlin", price = 1, availability = true, age = 27)))
}