package com.example.shalatapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shalatapp.adapter.DalilAdapter
import com.example.shalatapp.databinding.FragmentDalilBinding
import com.example.shalatapp.model.DalilShalatItem
import com.example.shalatapp.network.RetrofitInterface
import com.example.shalatapp.network.RetrofitService
import com.example.shalatapp.room.RoomDB
import kotlinx.coroutines.launch

class FragmentDalil : Fragment() {

    private lateinit var binding : FragmentDalilBinding
    private lateinit var fragmentDalilAdapter : DalilAdapter
//    private lateinit var roomDB: RoomDB

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDalilBinding.inflate(inflater,container,false)

//        roomDB = context?.let { RoomDB.getRoomDatabaseItem(it) } !!
        fragmentDalilAdapter = DalilAdapter()
        binding.recyclerDalil.adapter = fragmentDalilAdapter
        binding.recyclerDalil.setHasFixedSize(true)
        binding.recyclerDalil.layoutManager = LinearLayoutManager(context)

        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val dataItemDalil = roomDB.roomDao().getDataByType("Dalil")

//        dataItemDalil.observe(viewLifecycleOwner) {
//            if (it.isNotEmpty()) {
//                fragmentDalilAdapter.addData(it)
//                fragmentDalilAdapter.notifyDataSetChanged()
//            } else {
//                Toast.makeText(context, "Database Tidak Ditemukan", Toast.LENGTH_SHORT).show()
//
                val retrofitService = RetrofitService.buildService(RetrofitInterface::class.java)

                viewLifecycleOwner.lifecycleScope.launch {
                    val requestDataDalil = retrofitService.getDalil()
                    // Kondisi saat sukses show data
                    if (requestDataDalil.isSuccessful) {
                        val dataDalil = requestDataDalil.body() as List<DalilShalatItem>
                        fragmentDalilAdapter.addData(dataDalil)
                        fragmentDalilAdapter.notifyDataSetChanged()
//                    }
//                }
            }
        }
    }
}