package com.example.warsztat_mvvm.repository

import androidx.lifecycle.LiveData
import com.example.warsztat_mvvm.model.Doctor

interface DoctorsRepository {

    fun getDoctors(): LiveData<List<Doctor>>
}