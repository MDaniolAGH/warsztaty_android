package com.example.warsztat_mvvm.model

data class Doctor(
    val name: String,
    val specialization: String,
    val price: Int,
    val availability: Boolean,
    val age: Int
)