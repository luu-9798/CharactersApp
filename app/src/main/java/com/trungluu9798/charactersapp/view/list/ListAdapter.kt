package com.trungluu9798.charactersapp.view.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.trungluu9798.charactersapp.R
import com.trungluu9798.charactersapp.model.Data
import com.trungluu9798.charactersapp.model.RelatedTopics

class ListAdapter(
    data: Data? = null,
    val itemClickListener: (Int) -> Unit
) : RecyclerView.Adapter<ListAdapter.CharacterViewHolder>() {

    private var list: List<RelatedTopics> = listOf()

    init {
        list = data?.relatedTopics ?: listOf()
    }

    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView

        init {
            textView = itemView.findViewById(R.id.text_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.view_holder, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        list[position].getTitleAndDescription()
        holder.textView.text = list[position].title
        holder.itemView.setOnClickListener { itemClickListener(position) }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun getItem(position: Int): RelatedTopics {
        return list[position]
    }
}