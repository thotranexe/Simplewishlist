package com.example.simplewishlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter(private val wishlist : List<wishlist>): RecyclerView.Adapter<adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // Your holder should contain a member variable for any view that will be set as you render
        // a row
        val obView: TextView
        val priceView: TextView
        val urlView: TextView

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            obView= itemView.findViewById(R.id.item)
            priceView = itemView.findViewById(R.id.price)
            urlView= itemView.findViewById(R.id.url)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.wishlist_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int {
        return wishlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val list = wishlist.get(position)
        // Set item views based on views and data model
        holder.obView.text = list.item
        holder.priceView.text = "$"+list.price.toString()
        holder.urlView.text = list.url
    }
}