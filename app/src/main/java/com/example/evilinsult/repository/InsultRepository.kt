package com.example.evilinsult.repository

import com.example.evilinsult.db.InsultoDB
import com.example.evilinsult.db.InsultoDao
import com.example.evilinsult.models.Insulto
import com.example.evilinsult.models.InsultoEntidad
import com.example.evilinsult.network.InsultApi
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.NullPointerException
import javax.inject.Inject

@ActivityScoped
class InsultRepository @Inject constructor(
    private val api: InsultApi, // ==> REMOTO
    private val dao: InsultoDao //  ==>LOCAL
    ) {


    suspend fun getInsult():Insulto {
        return api.getInsult()
    }

    suspend fun insert(insultoEntidad: InsultoEntidad) = dao.insertInsult(insultoEntidad)

    suspend fun getAllInsults() = dao.getAllInsultos()
    
}


