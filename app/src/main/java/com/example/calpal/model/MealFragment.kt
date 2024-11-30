package com.example.calpal

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MealFragment : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_meal)

        val mealImages : ImageView = findViewById(R.id.meal_image);
        val mealName : TextView = findViewById(R.id.meal_name);

        val bundle : Bundle ?= intent.extras

        val imageId1 = bundle!!.getInt("meal_image")
        val names = bundle.getString("meal_name")

        mealImages.setImageResource(imageId1)
        mealName.text = names;
    }
}

