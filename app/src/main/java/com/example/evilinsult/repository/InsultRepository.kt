package com.example.evilinsult.repository

import com.example.evilinsult.models.Insulto
import com.example.evilinsult.network.InsultApi
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class InsultRepository @Inject constructor(private val api: InsultApi) {


    suspend fun getInsult():Insulto {
        return api.getInsult()
    }
}


