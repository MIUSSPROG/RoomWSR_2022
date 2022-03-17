package com.example.roomwsr_2022.manyToMany

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Instructor(
    @PrimaryKey
    var instructorId: Int,
    var name: String
)