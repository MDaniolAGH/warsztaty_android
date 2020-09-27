package com.example.warsztat_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warsztat_mvvm.model.Doctor
import com.example.warsztat_mvvm.view.DoctorsAdapter
import com.example.warsztat_mvvm.viewmodel.DoctorViewModel
import com.example.warsztat_mvvm.viewmodel.DoctorViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class DoctorActivity : AppCompatActivity() {

    private lateinit var viewModel: DoctorViewModel
    private lateinit var viewModelFactory: DoctorViewModelFactory

    private lateinit var adapter: DoctorsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = DoctorsAdapter()
        doctor_list.layoutManager = LinearLayoutManager(this)
        doctor_list.adapter = adapter

        viewModelFactory = DoctorViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(DoctorViewModel::class.java)

        viewModel.getDoctors().observe(this, Observer { doctorList ->
            adapter.updateDoctorList(doctorList)
        })
    }
}