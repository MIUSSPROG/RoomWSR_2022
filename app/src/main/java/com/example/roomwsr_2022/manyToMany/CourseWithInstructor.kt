package com.example.roomwsr_2022.manyToMany

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity( primaryKeys = ["courseId", "instructorId"],
    foreignKeys = [
        ForeignKey(
            entity = Course::class,
            parentColumns = ["courseId"],
            childColumns = ["courseId"]
        ),
        ForeignKey(
            entity = Instructor::class,
            parentColumns = ["instructorId"],
            childColumns = ["instructorId"]
        )
    ]
)
data class CourseWithInstructor(
    val courseId: Int,
    val instructorId: Int
)

