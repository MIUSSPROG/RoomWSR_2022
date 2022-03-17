package com.example.roomwsr_2022.manyToMany

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey
    var courseId: Int,
    var name: String
)