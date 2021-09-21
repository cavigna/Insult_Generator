package com.example.evilinsult.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evilinsult.models.Insulto
import com.example.evilinsult.models.InsultoEntidad
import com.example.evilinsult.repository.InsultRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsultViewModel @Inject constructor (private val repository: InsultRepository) : ViewModel() {
    var insultoMutable = mutableStateOf(Insulto())
    var listaInsulto = mutableStateOf(listOf(InsultoEntidad()))

    init {
        getInsult()
        selectAll()
    }


    fun getInsult(){
        viewModelScope.launch(IO) {
            insultoMutable.value = repository.getInsult()
        }
    }

    fun selectAll(){
        viewModelScope.launch {
            listaInsulto.value = repository.getAllInsults()
        }
    }

    fun insert(insulto: Insulto){
        viewModelScope.launch {
            val insultoAgregar = InsultoEntidad(insulto.id.toInt(), insulto.insult, insulto.language)
            repository.insert(insultoAgregar)
        }
    }
}