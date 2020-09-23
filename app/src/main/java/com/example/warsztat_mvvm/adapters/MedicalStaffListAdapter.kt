package com.example.warsztat_mvvm.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.warsztat_mvvm.R

import com.example.warsztat_mvvm.models.StaffMember
import kotlinx.android.synthetic.main.item_staff.view.*

class MedicalStaffListAdapter(private val result: List<StaffMember>) : RecyclerView.Adapter<MedicalStaffListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_staff, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindMedicalStaffMember(result[position])
    }

    override fun getItemCount(): Int = result.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bindMedicalStaffMember(member: StaffMember) {
            with(member) {

                itemView.name.text = member.name.orEmpty()

                itemView.specialization.text = member.specialization.orEmpty()
                itemView.additionalInfo.text = "Price:" + member.price.toString()
            }
        }
    }
}