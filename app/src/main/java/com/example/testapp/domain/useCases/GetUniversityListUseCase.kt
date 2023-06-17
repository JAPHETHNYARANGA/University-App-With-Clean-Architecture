package com.example.testapp.domain.useCases

import com.example.testapp.data.repositories.UniversityRepository
import com.example.testapp.domain.models.UniversityList
import javax.inject.Inject

class GetUniversityListUseCase @Inject constructor(private val universityRepository: UniversityRepository) {
    suspend fun execute(): List<UniversityList> {
        return universityRepository.getCountries()
    }
}