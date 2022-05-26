package com.example.shalatapp.adapter

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shalatapp.databinding.ItemRecyclerBatalShalatBinding
import com.example.shalatapp.fragment.FragmentBatalShalatDirections
import com.example.shalatapp.model.BatalShalatItem
import com.example.shalatapp.model.DalilShalatItem

class BatalShalatViewHolder (val batalShalatBinding : ItemRecyclerBatalShalatBinding) : RecyclerView.ViewHolder(batalShalatBinding.root) {
    fun bindView(item: DalilShalatItem) {
        itemView.run {
            Glide.with(this).load(item.gambar).into(batalShalatBinding.imgBatalShalat)
            batalShalatBinding.txtJudulBatalShalat.text = item.judul
            batalShalatBinding.txtDeskBatalShalat.text = item.deskripsi
        }
    }
}