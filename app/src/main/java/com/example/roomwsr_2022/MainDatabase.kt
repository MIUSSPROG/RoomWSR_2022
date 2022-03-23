package com.example.roomwsr_2022

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomwsr_2022.manyToMany.Course
import com.example.roomwsr_2022.manyToMany.CourseWithInstructor
import com.example.roomwsr_2022.manyToMany.Instructor
import com.example.roomwsr_2022.migrations.MigrationDeleteColumnStars
import com.example.roomwsr_2022.migrations.MigrationRenameRatingToStar
import com.example.roomwsr_2022.oneToMany.Apartment
import com.example.roomwsr_2022.oneToMany.User
import com.example.roomwsr_2022.oneToMany_Relation.Apartment2
import com.example.roomwsr_2022.oneToMany_Relation.User2


@Database(
    version = 6,
    entities = [
        User::class,
        Apartment::class,
        User2::class,
        Apartment2::class,
        Course::class,
        Instructor::class,
        CourseWithInstructor::class
    ],
    autoMigrations = [
        AutoMigration(from = 3, to = 4),
        AutoMigration(from = 4, to = 5, spec = MigrationRenameRatingToStar::class),
        AutoMigration(from = 5, to = 6, spec = MigrationDeleteColumnStars::class)
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
                ).build().also {
                    INSTANCE = it
                }
            }
        }
    }
}