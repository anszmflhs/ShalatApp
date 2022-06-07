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
import com.example.shalatapp.adapter.ShalatAdapter
import com.example.shalatapp.databinding.FragmentShalatBinding
import com.example.shalatapp.model.DalilShalatItem
import com.example.shalatapp.model.ShalatItem
import com.example.shalatapp.network.RetrofitInterface
import com.example.shalatapp.network.RetrofitService
import com.example.shalatapp.room.RoomDB
import kotlinx.coroutines.launch

class FragmentShalat : Fragment() {

    private lateinit var binding: FragmentShalatBinding
    private lateinit var shalatAdapter: ShalatAdapter
//    private lateinit var roomDB: RoomDB

    //    @SuppressLint("UseRequireInsteadOfGet")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentShalatBinding.inflate(inflater, container, false)

//        roomDB = view?.let { RoomDB.getRoomDatabaseItem(it.context) } !!
//        roomDB = context?.let { RoomDB.getRoomDatabaseItem(it) }!!
        shalatAdapter = ShalatAdapter()
        binding.recyclerShalat.setHasFixedSize(true)
        binding.recyclerShalat.layoutManager = LinearLayoutManager(context)
        binding.recyclerShalat.adapter = shalatAdapter

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

    viewLifecycleOwner.lifecycleScope.launch {
        val requestDataShalat = retrofitService.getDataShalatWajib()

        if (requestDataShalat.isSuccessful) {
            val dataShalat = requestDataShalat.body() as List<ShalatItem>
            shalatAdapter.addData(dataShalat)
            shalatAdapter.notifyDataSetChanged()
        }
    }
        // Memberi nama data yang berasal dari Shalat Fragment
//        val dataItemShalat = roomDB.roomDao().getDataByType("Shalat")

//        dataItemShalat.observe(viewLifecycleOwner) {
//            Log.e("Banyaknya Data", it.size.toString())
//            if (it.isNotEmpty()) {
//                shalatAdapter.addData(it)
//                shalatAdapter.notifyDataSetChanged()
//            } else {
//                Toast.makeText(context, "Database Tidak Ditemukan", Toast.LENGTH_SHORT).show()
//
//                val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)
//
//                viewLifecycleOwner.lifecycleScope.launch {
//                    val requestDataShalat = retrofitService.getDataShalatWajib()
//                    // Kondisi saat sukses show data
//                    if (requestDataShalat.isSuccessful) {
//                        val dataShalat = requestDataShalat.body() as List<ShalatItem>
//                        dataShalat.forEach {
//                            it.type = "Shalat"
//                        }
//                        roomDB.roomDao().insertData(dataShalat)
//                    }
//                }
            }
        }
//    }
//}