package com.girondins4ever.g4etest.ui.postList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.girondins4ever.g4etest.R

class PostRecyclerViewAdapter(
    private val values: List<Post>
) : RecyclerView.Adapter<PostRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.date.text = item.date
        holder.title.text = item.title
        holder.preview.text = item.preview
        holder.itemView.setOnClickListener {
            val action = PostFragmentDirections.actionNavigationNewsToPostDetails()
            it.findNavController().navigate(action)
        }
    }
    override fun getItemCount(): Int = values.size

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val date: TextView = view.findViewById(R.id.post_item_date)
        val title: TextView = view.findViewById(R.id.post_item_title)
        val preview: TextView = view.findViewById(R.id.post_item_preview)

        override fun toString(): String {
            return super.toString() + " '" + title + "'"
        }

    }
}