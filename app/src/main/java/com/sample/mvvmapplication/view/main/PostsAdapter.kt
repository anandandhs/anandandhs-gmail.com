package com.sample.mvvmapplication.view.main

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sample.mvvmapplication.R
import com.sample.mvvmapplication.model.PostsItem
import kotlinx.android.synthetic.main.main_recycler_view.view.*

class PostsAdapter(private val dataList : ArrayList<PostsItem>, private val listener: Listener) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {

    interface Listener {

        fun onItemClick(android : PostsItem)
    }

    private val colors : Array<String> = arrayOf("#EF5350", "#EC407A", "#AB47BC", "#7E57C2", "#5C6BC0", "#42A5F5")

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(dataList[position], listener, colors, position)
    }

    override fun getItemCount(): Int = dataList.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.main_recycler_view, parent, false)

        return ViewHolder(view)
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {

        fun bind(android: PostsItem, listener: Listener, colors : Array<String>, position: Int) {

            itemView.textView.text = android.id.toString()
            itemView.textView2.text = android.userId.toString()
            itemView.textView3.text = android.title
            itemView.setBackgroundColor(Color.parseColor(colors[position % 6]))

            itemView.setOnClickListener{ listener.onItemClick(android) }
        }
    }
}