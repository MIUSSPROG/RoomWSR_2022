package com.example.roomwsr_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.roomwsr_2022.oneToMany.Apartment
import com.example.roomwsr_2022.oneToMany.User
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = MainDatabase.getInstance(this).mainDao

        val users = listOf(
            User(id = 1, name = "Test1"),
            User(id = 2, name = "Test2")
        )

        val apartments = listOf(
            Apartment(id = 1, address = "Moscow, Alexander Monahovoi", userId = 1),
            Apartment(id = 2, address = "Moscow, Ozernaya", userId = 1),
            Apartment(id = 3, address = "Moscow, Moscouski", userId = 2)
        )

        lifecycleScope.launch {
            users.forEach { dao.insertUser(it) }
            apartments.forEach { dao.insertApartment(it) }

            val res = dao.getUserApartments()
            Log.d("room", res.toString())
            val groupRes = dao.getUserAndApartmentCountMap(0)
            Log.d("room", groupRes.toString())
        }
    }
}