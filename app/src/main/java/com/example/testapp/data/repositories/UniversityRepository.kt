package com.example.testapp.data.repositories

import com.example.testapp.data.network.RetrofitInterface
import com.example.testapp.domain.models.UniversityList
import javax.inject.Inject

class UniversityRepository @Inject constructor(private val retrofitInterface: RetrofitInterface) {
    suspend fun getCountries() : List<UniversityList>{
        return retrofitInterface.getCountries()
    }
}