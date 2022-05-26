package com.example.shalatapp.adapter

import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.shalatapp.databinding.ItemRecyclerDalilBinding
import com.example.shalatapp.fragment.FragmentDalilDirections
import com.example.shalatapp.model.DalilShalatItem

class DalilViewHolder (val dalilBinding : ItemRecyclerDalilBinding) : RecyclerView.ViewHolder(dalilBinding.root) {
    fun bindView(item : DalilShalatItem) {
        itemView.run {
            Glide.with(this).load(item.gambar).into(dalilBinding.imgDalil)
            dalilBinding.txtJudulDalil.text = item.judul
            dalilBinding.txtDescDalil.text = item.deskripsi
        }
    }
}