package com.example.calpal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.calpal.model.MealAdapter
import com.example.calpal.model.Meal

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView;
    private lateinit var mealsList : ArrayList<Meal>

    lateinit var meal_image : List<Int>
    lateinit var meal_name : Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        meal_image = listOf(
            R.drawable.breakfast,
            R.drawable.lunch,
            R.drawable.dinner,
            R.drawable.snack
        )


        meal_name = resources.getStringArray(R.array.meal_name)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        mealsList = arrayListOf<Meal>()
        loadMeals();
    }

    private fun loadMeals() {

        for(i in meal_image.indices){
            val meal = Meal(meal_image[i], meal_name[i])
            mealsList.add(meal)
        }

        var adapter = MealAdapter(this, mealsList)
        recyclerView.adapter = adapter;
        adapter.setOnItemClickListener(object : MealAdapter.onItemClickListener{
            override fun onItemClick(position: Int) {

                val intent = Intent(this@MainActivity, MealFragment::class.java)
                intent.putExtra("meal_name", mealsList[position].mealName)
                intent.putExtra("meal_image", mealsList[position].mealImage)

                startActivity(intent)
            }
        }
        )
    }
}

