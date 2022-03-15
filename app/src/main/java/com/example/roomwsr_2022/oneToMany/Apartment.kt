package com.example.roomwsr_2022.oneToMany

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = CASCADE,
            onUpdate = CASCADE
        )
    ]
)
data class Apartment(
    @PrimaryKey
    val id: Int,
    val address: String,
    val userId: Int
)