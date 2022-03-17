package com.example.roomwsr_2022

import android.icu.number.IntegerWidth
import androidx.room.*
import com.example.roomwsr_2022.manyToMany.Course
import com.example.roomwsr_2022.manyToMany.CourseWithInstructor
import com.example.roomwsr_2022.manyToMany.Instructor
import com.example.roomwsr_2022.oneToMany.Apartment
import com.example.roomwsr_2022.oneToMany.User
import com.example.roomwsr_2022.oneToMany_Relation.Apartment2
import com.example.roomwsr_2022.oneToMany_Relation.InstructorsOfCourse
import com.example.roomwsr_2022.oneToMany_Relation.User2
import com.example.roomwsr_2022.oneToMany_Relation.UserWithApartments

@Dao
interface MainDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApartment(apartment: Apartment)

    @MapInfo(keyColumn = "name")
    @Query("SELECT name, Apartment.* FROM User JOIN Apartment ON User.id = Apartment.userId")
    suspend fun getUserApartments(): Map<String, List<Apartment>>

    @MapInfo(valueColumn = "apartmentCount", keyColumn = "name")
    @Query("SELECT User.*, COUNT(Apartment.id) as apartmentCount FROM User JOIN Apartment " +
            "ON User.id = Apartment.userId " +
            "GROUP BY name HAVING apartmentCount > :apartmentCount")
    suspend fun getUserAndApartmentCountMap(apartmentCount: Int): Map<String, Int>

//    one to many (Relation)

    @Transaction
    @Query("SELECT * FROM User2")
    suspend fun getUsersWithApartments(): List<UserWithApartments>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser2(user: User2)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApartment2(apartment: Apartment2)

//    many to many

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: Course)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInstructor(instructor: Instructor)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourseWithInstructor(courseWithInstructor: CourseWithInstructor)

    @Transaction
    @Query("SELECT * FROM Course")
    suspend fun getInstructorsOnCourses(): List<InstructorsOfCourse>

}