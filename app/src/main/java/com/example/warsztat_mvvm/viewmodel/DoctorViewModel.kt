package com.example.warsztat_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.warsztat_mvvm.model.Doctor
import com.example.warsztat_mvvm.repository.DoctorsRepository


class DoctorViewModel(repository: DoctorsRepository) : ViewModel() {

    private val doctors: LiveData<List<Doctor>> = repository.getDoctors()

    fun getDoctors(): LiveData<List<Doctor>> = doctors
}