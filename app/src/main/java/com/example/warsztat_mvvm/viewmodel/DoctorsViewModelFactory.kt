package com.example.warsztat_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.warsztat_mvvm.repository.DoctorsRepositoryImpl
import java.lang.IllegalArgumentException

class DoctorViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(DoctorViewModel::class.java)) {
            return DoctorViewModel(
                repository = DoctorsRepositoryImpl()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel")
    }
}