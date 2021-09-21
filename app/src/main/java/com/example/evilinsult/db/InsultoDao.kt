package com.example.evilinsult.db

import androidx.room.*

import com.example.evilinsult.models.InsultoEntidad

@Dao
interface InsultoDao {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInsult(insulto: InsultoEntidad)

    @Delete
    suspend fun deleteInsulto(insulto: InsultoEntidad)

    @Query("SELECT * FROM insultoentidad")
    suspend fun getAllInsultos(): List<InsultoEntidad>


}

/*
@Dao
interface LibroDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun agregarLibro(libro: LibroEntity)

    @Delete
    suspend fun eliminarLibro(libro: LibroEntity)

    @Query("DELETE  FROM favoritos")
    suspend fun deleteAll()

    @Query("SELECT * FROM favoritos")
     fun selectAll() : LiveData<List<LibroEntity>>







}
 */