package com.cirodevs.onlineshop2025.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.cirodevs.onlineshop2025.Domain.CategoryModel
import com.cirodevs.onlineshop2025.R
import com.cirodevs.onlineshop2025.databinding.ViewholderCategoryBinding


class CategoryAdapter (val items: MutableList<CategoryModel>):
    RecyclerView.Adapter<CategoryAdapter.viewholder>(){

    private lateinit var  context : Context
    private var selectedPosition = -1
    private var lastSelectedPosition = -1



    class viewholder(val binding : ViewholderCategoryBinding):
    RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryAdapter.viewholder {
        context= parent.context
        val binding = ViewholderCategoryBinding.inflate(LayoutInflater.from(context), parent, false)
        return viewholder(binding)
    }

    override fun onBindViewHolder(holder: CategoryAdapter.viewholder, position:Int) {
        val item = items[ position ]
        holder.binding.titleCatTxt.text= item.title

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }

        if(selectedPosition == position){
            holder.binding.titleCatTxt.setBackgroundResource(R.drawable.orange_bg)
            holder.binding.titleCatTxt.setTextColor(context.resources.getColor(R.color.white))

        }else{
            holder.binding.titleCatTxt.setBackgroundResource(R.drawable.grey_bg)
            holder.binding.titleCatTxt.setTextColor(context.resources.getColor(R.color.black))

        }
    }

    override fun getItemCount(): Int = items.size

}


