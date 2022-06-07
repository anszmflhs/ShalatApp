package com.example.shalatapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shalatapp.adapter.BatalShalatAdapter
import com.example.shalatapp.databinding.FragmentBatalShalatBinding
import com.example.shalatapp.model.BatalShalatItem
import com.example.shalatapp.model.DalilShalatItem
import com.example.shalatapp.network.RetrofitInterface
import com.example.shalatapp.network.RetrofitService
import com.example.shalatapp.room.RoomDB
import kotlinx.coroutines.launch

class FragmentBatalShalat : Fragment() {

    private lateinit var binding : FragmentBatalShalatBinding
    private lateinit var batalShalatAdapter : BatalShalatAdapter
    private lateinit var roomDB : RoomDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBatalShalatBinding.inflate(inflater,container,false)

        roomDB = context?.let { RoomDB.getRoomDatabaseItem(it) }!!

        batalShalatAdapter = BatalShalatAdapter()
        binding.recyclerBatalShalat.adapter = batalShalatAdapter
        binding.recyclerBatalShalat.setHasFixedSize(true)
        binding.recyclerBatalShalat.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataItemBatalShalat = roomDB.roomDao().getDataByType("BatalShalat")

        dataItemBatalShalat.observe(viewLifecycleOwner) {
            Log.e("Banyaknya Data", it.size.toString())
            if (it.isNotEmpty()) {
                batalShalatAdapter.addData(it)
                batalShalatAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(context, "Database Tidak Ditemukan :(", Toast.LENGTH_SHORT).show()
                val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

                viewLifecycleOwner.lifecycleScope.launch {
                    val requestDataBatalShalat = retrofitService.getDataBatalShalat()
                    // Kondisi saat sukses show data
                    if (requestDataBatalShalat.isSuccessful) {
                        val dataBatalShalat = requestDataBatalShalat.body() as List<BatalShalatItem>
                        dataBatalShalat.forEach {
                            it.type = "BatalShalat"
                        }
                        roomDB.roomDao().insertData(dataBatalShalat)
                    }
                }
            }
        }
    }
}