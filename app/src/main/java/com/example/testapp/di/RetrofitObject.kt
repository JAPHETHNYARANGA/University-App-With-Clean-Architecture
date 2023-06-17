package com.example.testapp.di

import com.example.testapp.data.network.RetrofitInterface
import com.example.testapp.data.repositories.UniversityRepository
import com.example.testapp.domain.useCases.GetUniversityListUseCase
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


@Module
@InstallIn(SingletonComponent::class)
object RetrofitObject {
    private const val BASE_URL = "http://universities.hipolabs.com/"

    @Provides
    fun provideGson():Gson{
        return GsonBuilder().create()
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun provideRetrofitInterface(retrofit: Retrofit):RetrofitInterface{
        return retrofit.create(RetrofitInterface::class.java)
    }

    @Provides
    fun provideUniversityRepository(retrofitInterface: RetrofitInterface):UniversityRepository{
        return UniversityRepository(retrofitInterface)
    }

    @Provides
    fun provideGetUniversityListUseCase(universityRepository: UniversityRepository): GetUniversityListUseCase{
        return GetUniversityListUseCase(universityRepository)
    }
}