package com.udacity.shoestore

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.udacity.shoestore.models.Shoe

class ListAdapter(private val list: List<Shoe>)
    : RecyclerView.Adapter<ShoeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ShoeViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: ShoeViewHolder, position: Int) {
        val shoe: Shoe = list[position]
        holder.bind(shoe)
    }

    override fun getItemCount(): Int = list.size

}


class ShoeViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.list_item, parent, false)) {
    private var mTitleView: TextView? = null
    private var mDescView: TextView? = null


    init {
        mTitleView = itemView.findViewById(R.id.list_title)
        mDescView = itemView.findViewById(R.id.list_description)
    }

    fun bind(shoe: Shoe) {
        mTitleView?.text = shoe.name
        mDescView?.text = shoe.description + ", " + shoe.company +", " + shoe.size
    }

}