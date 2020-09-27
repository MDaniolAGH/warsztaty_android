package com.example.warsztat_mvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.warsztat_mvvm.R
import com.example.warsztat_mvvm.model.Doctor
import kotlinx.android.synthetic.main.item_doctor.view.*

class DoctorsAdapter() : RecyclerView.Adapter<DoctorsAdapter.ViewHolder>() {

    private var doctorList: List<Doctor> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_doctor, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.nameText.text = doctorList[position].name
    }

    override fun getItemCount(): Int = doctorList.size

    fun updateDoctorList(doctorList: List<Doctor>) {
        this.doctorList = doctorList
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameText = itemView.name
    }
}