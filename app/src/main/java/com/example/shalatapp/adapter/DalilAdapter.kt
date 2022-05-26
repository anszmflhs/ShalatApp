package com.example.shalatapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shalatapp.DetailActivity
import com.example.shalatapp.databinding.ItemRecyclerDalilBinding
import com.example.shalatapp.fragment.FragmentDalilDirections
import com.example.shalatapp.model.DalilShalatItem

class DalilAdapter : RecyclerView.Adapter<DalilViewHolder>() {

    private var listItemDalil = arrayListOf<DalilShalatItem>()

    fun addData(items : List<DalilShalatItem>) {
        listItemDalil.clear()
        listItemDalil.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DalilViewHolder {
        val listItemDalilBinding = ItemRecyclerDalilBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DalilViewHolder(listItemDalilBinding)
    }

    override fun onBindViewHolder(holder: DalilViewHolder, position: Int) {
        val data = listItemDalil[position]
        holder.bindView(data)

        holder.itemView.setOnClickListener {
            val intent = Intent(it.context,DetailActivity::class.java)
            intent.putExtra(DetailActivity.Detail_Data, data)
            it.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return listItemDalil.size
    }
}