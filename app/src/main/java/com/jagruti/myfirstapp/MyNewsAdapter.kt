package com.jagruti.myfirstapp

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.jagruti.myfirstapp.databinding.ListViewNewsItemsBinding

class MyNewsAdapter(var newsArrayList: ArrayList<News>, var context: Activity) :
    RecyclerView.Adapter<MyNewsAdapter.MyViewHolder>() {

    //to create new view instance
    // when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): MyViewHolder {
        val binding =
            ListViewNewsItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        val  itemView= LayoutInflater.from(parent.context).inflate(R.layout.list_view_news_items,parent,false)
        return MyViewHolder(binding)
    }

    //populate items with data
    override fun onBindViewHolder(
        holder: MyViewHolder, position: Int
    ) {
        val currentItem = newsArrayList[position]
        holder.binding.ivNews.setImageResource(currentItem.newsImage)
        holder.binding.tvTitle.text = currentItem.newsHeading
        holder.itemView.setOnClickListener { Toast.makeText(
            context,
            "${currentItem.newsHeading}\n${currentItem.newsHeading}",
            Toast.LENGTH_LONG
        ).show() }
    }

    // how many list items are presented in your array
    override fun getItemCount(): Int {
        Log.d("count", newsArrayList.size.toString())
        return newsArrayList.size
    }

    //it holds the view so view are not created everytime, so memory can be saved
    class MyViewHolder(val binding: ListViewNewsItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

}
