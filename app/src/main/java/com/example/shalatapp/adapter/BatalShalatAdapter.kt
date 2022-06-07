package com.example.shalatapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shalatapp.DetailActivity
import com.example.shalatapp.databinding.ItemRecyclerBatalShalatBinding
import com.example.shalatapp.model.BatalShalatItem
import com.example.shalatapp.model.DalilShalatItem

class BatalShalatAdapter : RecyclerView.Adapter<BatalShalatViewHolder>() {

    private var listItemBatalShalat = arrayListOf<BatalShalatItem>()

    fun addData(items : List<BatalShalatItem>) {
        listItemBatalShalat.clear()
        listItemBatalShalat.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BatalShalatViewHolder {
        val listItemBatalShalatBinding = ItemRecyclerBatalShalatBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BatalShalatViewHolder(listItemBatalShalatBinding)
    }

    override fun onBindViewHolder(holder: BatalShalatViewHolder, position: Int) {
        val data = listItemBatalShalat[position]
        holder.bindView(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.Detail_Data, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listItemBatalShalat.size
    }
}

