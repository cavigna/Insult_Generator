package com.example.evilinsult.di

import com.example.evilinsult.network.InsultApi
import com.example.evilinsult.repository.InsultRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideInsultRepository(api: InsultApi) = InsultRepository(api)

    @Singleton
    @Provides
    fun provideInsultApi(): InsultApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://evilinsult.com/")
            .build()
            .create(InsultApi::class.java)
    }


}