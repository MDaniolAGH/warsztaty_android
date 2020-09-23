package com.example.warsztat_mvvm

import android.util.Log
import com.example.warsztat_mvvm.adapters.MedicalStaffListAdapter
import com.example.warsztat_mvvm.api.StaffListRetriever
import com.example.warsztat_mvvm.models.StaffMember
import com.example.warsztat_mvvm.repository.MainRepository
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call

import retrofit2.Callback
import retrofit2.Response

interface ViewModelCallbackSupporting {
    fun onListFetchedSuccessful(data: List<StaffMember>?)
}

class MainActivityViewModel(delegate: ViewModelCallbackSupporting) {

    private val apiRetriever = StaffListRetriever()
    var title = "Medical Staff Available"

    private val onDataRetrieved = object : Callback<List<StaffMember>> {
        override fun onFailure(call: Call<List<StaffMember>>?, t: Throwable?) {
            Log.e("MainActivity", "Problem calling MedStaff API ${t?.message}")
        }

        override fun onResponse(
            call: Call<List<StaffMember>>?,
            response: Response<List<StaffMember>>?
        ) {
            response?.isSuccessful.let {
                val responseData = response?.body()
               delegate.onListFetchedSuccessful(responseData)
            }
        }
    }

    fun getMedicalStaffData() {
        MainRepository(apiRetriever).getMedicalStaff(onDataRetrieved)
    }
}