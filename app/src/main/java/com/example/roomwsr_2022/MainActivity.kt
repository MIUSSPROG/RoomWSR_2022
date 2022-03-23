package com.example.roomwsr_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.roomwsr_2022.manyToMany.Course
import com.example.roomwsr_2022.manyToMany.CourseWithInstructor
import com.example.roomwsr_2022.manyToMany.Instructor
import com.example.roomwsr_2022.oneToMany.Apartment
import com.example.roomwsr_2022.oneToMany.User
import com.example.roomwsr_2022.oneToMany_Relation.Apartment2
import com.example.roomwsr_2022.oneToMany_Relation.User2
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = MainDatabase.getInstance(this).mainDao

//        one to many (SQL) -----------------
//        val users = listOf(
//            User(id = 1, name = "Test1"),
//            User(id = 2, name = "Test2")
//        )
//
//        val apartments = listOf(
//            Apartment(id = 1, address = "Moscow, Alexander Monahovoi", userId = 1),
//            Apartment(id = 2, address = "Moscow, Ozernaya", userId = 1),
//            Apartment(id = 3, address = "Moscow, Moscouski", userId = 2)
//        )

//        lifecycleScope.launch {
//            users.forEach { dao.insertUser(it) }
//            apartments.forEach { dao.insertApartment(it) }
//
//            val res = dao.getUserApartments()
//            Log.d("room", res.toString())
//            val groupRes = dao.getUserAndApartmentCountMap(0)
//            Log.d("room", groupRes.toString())
//        }


//        one to many (Relation) ---------------------
//        val users = listOf(
//            User2(id = 1, name = "Test1"),
//            User2(id = 2, name = "Test2")
//        )
//
//        val apartments = listOf(
//            Apartment2(id = 1, address = "Moscow, Alexander Monahovoi", userId = 1),
//            Apartment2(id = 2, address = "Moscow, Ozernaya", userId = 1),
//            Apartment2(id = 3, address = "Moscow, Moscouski", userId = 2)
//        )
//
//        lifecycleScope.launch {
//            users.forEach { dao.insertUser2(it) }
//            apartments.forEach { dao.insertApartment2(it) }
//
//            val res = dao.getUsersWithApartments()
//            val out = res.map{ listOf(it.user, it.apartments) }
//            Log.d("room", out.toString())
//        }

//        many to many (Relation) ----------------
//        val course1 = Course(1, "course1")
//        val course2 = Course(2, "course2")
//        val instructor1 = Instructor(1, "instructor1")
//        val instructor2 = Instructor(2, "instructor2")
//
//        val courseWithInstructor1 = CourseWithInstructor(1, 1)
//        val courseWithInstructor2 = CourseWithInstructor(1, 2)
//        val courseWithInstructor3 = CourseWithInstructor(2, 1)
//
        lifecycleScope.launch {
//            dao.insertCourse(course1)
//            dao.insertCourse(course2)
//            dao.insertInstructor(instructor1)
//            dao.insertInstructor(instructor2)
//            dao.insertCourseWithInstructor(courseWithInstructor1)
//            dao.insertCourseWithInstructor(courseWithInstructor2)
//            dao.insertCourseWithInstructor(courseWithInstructor3)
            val res = dao.getInstructorsOnCourses()
            Log.d("room", res.toString())
        }

    }
}