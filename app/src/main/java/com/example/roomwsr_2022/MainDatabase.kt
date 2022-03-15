package com.example.roomwsr_2022

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomwsr_2022.oneToMany.Apartment
import com.example.roomwsr_2022.oneToMany.User


@Database(
    version = 1,
    entities = [
        User::class,
        Apartment::class
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