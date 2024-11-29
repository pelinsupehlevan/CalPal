package com.example.calpal.model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.calpal.R
import com.example.calpal.model.Meal

class MealAdapter(private val context : Context, private val mealsList : List<Meal>)
    : RecyclerView.Adapter<MealAdapter.ItemViewHolder>(){

    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

            fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }


    class ItemViewHolder(private val view: View, listener: onItemClickListener) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.meal_image)
        val textView: TextView = view.findViewById(R.id.meal_name)

        init {
            itemView.setOnClickListener{
                listener.onItemClick(adapterPosition)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.fragment_meal, parent, false)
        return ItemViewHolder(itemView, mListener);
    }

    override fun getItemCount(): Int {
        return mealsList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = mealsList[position]
        holder.imageView.setImageResource(currentItem.mealImage)
        holder.textView.text = currentItem.mealName
    }
}