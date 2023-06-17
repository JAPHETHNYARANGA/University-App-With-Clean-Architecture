package com.example.testapp.presentation.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.domain.models.UniversityList
import com.example.testapp.domain.useCases.GetUniversityListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UniversitiesViewModel @Inject constructor(private val getUniversityListUseCase: GetUniversityListUseCase):ViewModel() {
    private val _universityList = MutableStateFlow(emptyList<UniversityList>())
    val universityList: StateFlow<List<UniversityList>> get() = _universityList

    init {
        fetchUniversityList()
    }

    private fun fetchUniversityList(){
        viewModelScope.launch(Dispatchers.IO){
            try {
                val list = getUniversityListUseCase.execute()
                _universityList.value = list
                Log.d("Failure", "$list")
            }catch (e:Exception){
                Log.d("Failure", "${e.message}")
            }
        }
    }
}