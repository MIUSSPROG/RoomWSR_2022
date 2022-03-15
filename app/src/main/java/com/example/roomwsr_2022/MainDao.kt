package com.example.roomwsr_2022

import android.icu.number.IntegerWidth
import androidx.room.*
import com.example.roomwsr_2022.oneToMany.Apartment
import com.example.roomwsr_2022.oneToMany.User

@Dao
interface MainDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApartment(apartment: Apartment)


    @MapInfo(keyColumn = "name")
    @Query("SELECT name, Apartment.* FROM User JOIN Apartment ON User.id = Apartment.userId")
    suspend fun getUserApartments(): Map<String, List<Apartment>>

    @MapInfo(valueColumn = "apartmentCount")
    @Query("SELECT User.*, COUNT(Apartment.id) as apartmentCount FROM User JOIN Apartment ON User.id = Apartment.userId GROUP BY name HAVING apartmentCount > :apartmentCount")
    suspend fun getUserAndApartmentCountMap(apartmentCount: Int): Map<User, Int>

}