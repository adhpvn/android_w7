package com.example.adroidWeek7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Danh sách các họ và tên có sẵn
        val availableLastNames = listOf("Pham", "Vu","Nguyen","Tong" )
        val availableFirstNames = listOf("Son", "Trang", "Minh", "Duy")

        // Prepare arrays of data with random names
        val itemList = arrayListOf<ItemModel>()
        val random = Random()
        for (i in 1..15) {
            val randomLastName = availableLastNames.random()
            val randomFirstName = availableFirstNames.random()

            val fullName = "$randomLastName $randomFirstName"

            itemList.add(
                ItemModel(
                    i,
                    fullName,
                    "0922324467",
                    fullName.toLowerCase().replace(" ", "") + "@gmail.com"
                )
            )
        }

        val adapter = MyCustomAdapter(itemList, this)
        val recyclerView: RecyclerView = findViewById(R.id.RVLayout)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
}
