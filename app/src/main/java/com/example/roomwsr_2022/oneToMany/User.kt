package com.example.roomwsr_2022.oneToMany

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: Int,
    val name: String
)