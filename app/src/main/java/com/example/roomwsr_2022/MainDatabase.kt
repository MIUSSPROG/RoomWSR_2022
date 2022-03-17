package com.example.roomwsr_2022

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomwsr_2022.manyToMany.Course
import com.example.roomwsr_2022.manyToMany.CourseWithInstructor
import com.example.roomwsr_2022.manyToMany.Instructor
import com.example.roomwsr_2022.oneToMany.Apartment
import com.example.roomwsr_2022.oneToMany.User
import com.example.roomwsr_2022.oneToMany_Relation.Apartment2
import com.example.roomwsr_2022.oneToMany_Relation.User2


@Database(
    version = 3,
    entities = [
        User::class,
        Apartment::class,
        User2::class,
        Apartment2::class,
        Course::class,
        Instructor::class,
        CourseWithInstructor::class
    ]
)
abstract class MainDatabase() : RoomDatabase() {

    abstract val mainDao: MainDao

    companion object {
        private var INSTANCE: MainDatabase? = null

        fun getInstance(context: Context): MainDatabase{
            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    MainDatabase::class.java,
                    "main_database"
                ).fallbackToDestructiveMigration().build().also {
                    INSTANCE = it
                }
            }
        }
    }
}