package com.example.roomwsr_2022.oneToMany_Relation

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Apartment2(
    @PrimaryKey
    val id: Int,
    val address: String,
    val userId: Int
)