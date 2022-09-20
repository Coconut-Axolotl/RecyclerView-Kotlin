package com.example.recyclerview_kotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView



class ItemAdapter(private val items: MutableList<Items>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>(){


    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    class ViewHolder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val itemNameTextView: TextView
        val itemPriceTextView: TextView
        val itemURLTextView: TextView

        init {
            itemNameTextView = itemView.findViewById(R.id.listedName)
            itemPriceTextView = itemView.findViewById(R.id.listedPrice)
            itemURLTextView = itemView.findViewById(R.id.listedLink)

            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)


        val contactView = inflater.inflate(R.layout.list_item, parent, false)


        return ViewHolder(contactView, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val theItem = items.get(position)


        holder.itemNameTextView.text = theItem.Name
        holder.itemPriceTextView.text = theItem.Price
        holder.itemURLTextView.text = theItem.URL
    }

    override fun getItemCount(): Int {
        return items.size
    }
}


