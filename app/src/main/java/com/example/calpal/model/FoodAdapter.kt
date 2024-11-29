package com.example.calpal.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.calpal.R

class FoodAdapter(private val mListener : OnItemClickListener) :
    ListAdapter<Food, FoodAdapter.FoodViewHolder>(FoodDiffCallback()) {

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    class FoodViewHolder(itemView: View, private val listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        val foodNameView: TextView = itemView.findViewById(R.id.foodNameTextView)
        val foodCaloriesView: TextView = itemView.findViewById(R.id.foodCaloriesTextView)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.food_recycler_view, parent, false)
        return FoodViewHolder(view, mListener)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = getItem(position)
        holder.foodNameView.text = food.foodName
        holder.foodCaloriesView.text = food.calories.toString()
    }

    class FoodDiffCallback : DiffUtil.ItemCallback<Food>() {
        override fun areItemsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem.foodName == newItem.foodName
        }

        override fun areContentsTheSame(oldItem: Food, newItem: Food): Boolean {
            return oldItem == newItem
        }
    }
}
