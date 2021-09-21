package com.example.evilinsult.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class InsultoEntidad(
    @PrimaryKey
    val id: Int,

    val insulto: String,
    val language: String,

)