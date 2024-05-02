package com.example.fooddeliveryapp

import Adapter.PopularAdapter
import Domain.FoodDomain
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {


    private lateinit var adapter2: RecyclerView.Adapter<*>

    private lateinit var recyclerViewPopularList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        recyclerViewPopular()
        bottomNavigation()
    }

        private fun bottomNavigation() {

        }

        private fun recyclerViewPopular() {
            val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
            recyclerViewPopularList = findViewById(R.id.recyclerView2)
            recyclerViewPopularList.layoutManager = linearLayoutManager

            val foodList = ArrayList<FoodDomain>()
            foodList.add(FoodDomain("Pepperoni pizza", "pizza1", "slices pepperoni ,mozzarella cheese, fresh oregano,  ground black pepper, pizza sauce", 9.76))
            foodList.add(FoodDomain("Cheese Burger", "burger", "beef, Gouda Cheese, Special sauce, Lettuce, tomato ", 8.79))
            foodList.add(FoodDomain("Vegetable pizza", "pizza2", " olive oil, Vegetable oil, pitted Kalamata, cherry tomatoes, fresh oregano, basil", 8.5))

            adapter2 = PopularAdapter(foodList)
            recyclerViewPopularList.adapter = adapter2
        }


    }

