package com.example.roomwsr_2022.oneToMany_Relation

import androidx.room.Embedded
import androidx.room.Relation

data class UserWithApartments(
    @Embedded val user: User2,

    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val apartments: List<Apartment2>
)