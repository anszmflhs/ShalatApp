package com.example.shalatapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shalatapp.DetailActivity
import com.example.shalatapp.databinding.ItemRecyclerShalatBinding
import com.example.shalatapp.model.ShalatItem

class ShalatAdapter : RecyclerView.Adapter<ShalatViewHolder>() {

    private var listItemBatalShalat = arrayListOf<ShalatItem>()

    fun addData(items : List<ShalatItem>) {
        listItemBatalShalat.clear()
        listItemBatalShalat.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShalatViewHolder {

        // Metode ViewBinding
        val listItemShalatBinding = ItemRecyclerShalatBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ShalatViewHolder(listItemShalatBinding)
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_kategori,parent,false)
//        return ShalatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShalatViewHolder, position: Int) {
        val data = listItemBatalShalat[position]
        holder.bind(data)
    }

    override fun getItemCount(): Int {
        return listItemBatalShalat.size
    }
}