package com.example.shalatapp.adapter

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.shalatapp.databinding.ItemRecyclerShalatBinding
import com.example.shalatapp.model.ShalatItem

class ShalatViewHolder (val shalatBinding : ItemRecyclerShalatBinding) : RecyclerView.ViewHolder(shalatBinding.root) {
    fun bind(batalShalatItem : ShalatItem) {
        val adapterShalatItem = BatalShalatAdapter()
        itemView.run {
//            Glide.with(this).load(item.kategoriShalat).into(shalatBinding.imgDropdown)
            shalatBinding.txtShalat.text = batalShalatItem.title
            shalatBinding.recyclerShalats.setHasFixedSize(true)
            shalatBinding.recyclerShalats.layoutManager = LinearLayoutManager(context)
            shalatBinding.recyclerShalats.adapter = adapterShalatItem
        }
        adapterShalatItem.addData(batalShalatItem.data)
        adapterShalatItem.notifyDataSetChanged()
    }
}