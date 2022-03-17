package com.example.roomwsr_2022.oneToMany_Relation

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User2(
    @PrimaryKey
    val id: Int,
    val name: String
)