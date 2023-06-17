package com.example.testapp.data.network

import com.example.testapp.domain.models.UniversityList
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("search?country=United+States")
    suspend fun getCountries():List<UniversityList>
}