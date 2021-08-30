package com.deepak.hiltapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.deepak.hiltapplication.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class MainViewModel
@Inject
constructor(
    private val mainRepository: MainRepository
): ViewModel(){

    fun getDummyTest():String{
       saveData()
        return mainRepository.getDummyTest()
    }

    private fun saveData() {
        viewModelScope.launch {
             mainRepository.saveDummyData()
        }

    }
     fun getData():LiveData<String>{
        val result = MutableLiveData<String>()
        viewModelScope.launch {
        result.postValue(mainRepository.getBlogs())
        }
        return result
    }
}