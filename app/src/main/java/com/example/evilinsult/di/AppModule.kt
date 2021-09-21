package com.example.evilinsult.di

import android.content.Context
import androidx.room.Room
import com.example.evilinsult.db.InsultoDB
import com.example.evilinsult.db.InsultoDao
import com.example.evilinsult.models.Insulto
import com.example.evilinsult.network.InsultApi
import com.example.evilinsult.repository.InsultRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
//@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideInsultRepository(api: InsultApi, insultoDao: InsultoDao) = InsultRepository(api, insultoDao)

    @Singleton
    @Provides
    fun provideInsultApi(): InsultApi{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://evilinsult.com/")
            .build()
            .create(InsultApi::class.java)
    }

    // Proveedor de DAO
    @Provides
    fun providesInsultDao(insultoDB: InsultoDB) : InsultoDao = insultoDB.insultoDao()

    // Proveedor de BD
    @Provides
    @Singleton
    fun providesInsultoDB(@ApplicationContext context:Context): InsultoDB =
        Room.databaseBuilder(context, InsultoDB::class.java, "insulto_database")
            .build()


}

