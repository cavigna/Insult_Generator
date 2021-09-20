package com.example.evilinsult.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evilinsult.models.Insulto
import com.example.evilinsult.repository.InsultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsultViewModel @Inject constructor (private val repository: InsultRepository) : ViewModel() {
    var insultoMutable = mutableStateOf(Insulto())

    init {
        getInsult()
    }


    fun getInsult(){
        viewModelScope.launch(IO) {
            insultoMutable.value = repository.getInsult()
        }
    }
}