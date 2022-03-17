package com.example.roomwsr_2022.oneToMany_Relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.roomwsr_2022.manyToMany.Course
import com.example.roomwsr_2022.manyToMany.CourseWithInstructor
import com.example.roomwsr_2022.manyToMany.Instructor

data class InstructorsOfCourse(
    @Embedded
    var course: Course,

    @Relation(
        parentColumn = "courseId",
        entityColumn = "instructorId",
        associateBy = Junction(CourseWithInstructor::class)
    )
    var instructors: List<Instructor>
)